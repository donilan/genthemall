package com.ii2d.genthemall.source;

import groovy.util.ConfigObject;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ii2d.genthemall.exception.GenthemallException;

public class DatabaseSource extends ConfigObject {
	private static final long serialVersionUID = 1L;
	
	public static final Log LOG = LogFactory.getLog(DatabaseSource.class);

	@SuppressWarnings("unchecked")
	public DatabaseSource(DataSource dataSource, String table) {
		QueryRunner queryRunner = new QueryRunner(dataSource);
		final ConfigObject that = this;
		
		put("name", table);
		
		final ResultSetHandler<Boolean> h = new ResultSetHandler<Boolean>() {
			@Override
			public Boolean handle(ResultSet rs) throws SQLException {
				ResultSetMetaData md = rs.getMetaData();
				List<ConfigObject> attrs = new ArrayList<ConfigObject>();
				for (int i = 1; i <= md.getColumnCount(); ++i) {
					ConfigObject attr = new ConfigObject();
					attr.put("name", md.getColumnName(i));
					attr.put("length", md.getPrecision(i));
					attr.put("nullable", !(md.isNullable(i) == ResultSetMetaData.columnNoNulls));
					attr.put("className", md.getColumnClassName(i));

					// add source property to source.
					attrs.add(attr);

					if (LOG.isInfoEnabled())
						LOG.info(String
								.format("ColumnName [%s], ColumnClassName [%s]"
										+ ", CatalogName [%s], ColumnDisplaySize [%s]"
										+ ", ColumnLabel [%s], ColumnType [%s], ColumnTypeName [%s]"
										+ ", Precision [%d], Scale [%d]"
										+ ", SchemaName [%s], TableName [%s]",
										md.getColumnName(i),
										md.getColumnClassName(i),
										md.getCatalogName(i),
										md.getColumnDisplaySize(i),
										md.getColumnLabel(i),
										md.getColumnType(i),
										md.getColumnTypeName(i),
										md.getPrecision(i), md.getScale(i),
										md.getSchemaName(i), md.getTableName(i)));

				}
				that.put("attrs", attrs);
				return true;
			}

		};
		try {
			if (queryRunner.query(
					String.format("SELECT * FROM %s WHERE 1 = 2", table), h)) {
				LOG.info(String.format(
						"Find properties for table: [%s] success!", table));
			}
		} catch (SQLException e) {
			throw new GenthemallException(e);
		}
	}

}
