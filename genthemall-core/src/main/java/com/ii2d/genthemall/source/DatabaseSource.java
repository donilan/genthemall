package com.ii2d.genthemall.source;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ii2d.genthemall.exception.GenthemallException;

public class DatabaseSource extends AbstractSource implements Source {

	public static final Log LOG = LogFactory.getLog(DatabaseSource.class);
	
	protected BasicDataSource dataSource;
	protected QueryRunner queryRunner;

	public DatabaseSource(String driver, String url, String username,
			String password, String table) {
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		queryRunner = new QueryRunner(dataSource);

		_findProperties(table);
	}

	protected void _findProperties(String table) {
		final Source that = this;
		this.name = table;
		final ResultSetHandler<Boolean> h = new ResultSetHandler<Boolean>() {
			@Override
			public Boolean handle(ResultSet rs) throws SQLException {
				ResultSetMetaData md = rs.getMetaData();
				for (int i = 1; i <= md.getColumnCount(); ++i) {
					SourceProperty sp = new SourceProperty();
					sp.setName(md.getColumnName(i));
					sp.setLength(md.getPrecision(i));
					sp.setNullable(!(md.isNullable(i) == ResultSetMetaData.columnNoNulls));
					sp.setClassName(md.getColumnClassName(i));
					
					// add source property to source.
					that.addSourceProperty(sp);
					
					if(LOG.isInfoEnabled())
						LOG.info(String.format("ColumnName [%s], ColumnClassName [%s]" +
								", CatalogName [%s], ColumnDisplaySize [%s]" +
								", ColumnLabel [%s], ColumnType [%s], ColumnTypeName [%s]" +
								", Precision [%d], Scale [%d]" +
								", SchemaName [%s], TableName [%s]"
								, md.getColumnName(i)
								, md.getColumnClassName(i)
								, md.getCatalogName(i)
								, md.getColumnDisplaySize(i)
								, md.getColumnLabel(i)
								, md.getColumnType(i)
								, md.getColumnTypeName(i)
								, md.getPrecision(i)
								, md.getScale(i)
								, md.getSchemaName(i)
								, md.getTableName(i)
								));
					
				}
				
				return true;
			}

		};
		try {
			if (queryRunner.query(String.format("SELECT * FROM %s WHERE 1 = 2", table), h)) {
				LOG.info(String.format("Find properties for table: [%s] success!", table));
			}
		} catch (SQLException e) {
			throw new GenthemallException(e);
		}
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		if (dataSource != null) {
			dataSource.close();
		}
	}

}
