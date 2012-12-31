**GenThemAll 生成你想要的！**

GenThemAll 是一个代码生成工具，核心思想是根据数据库源（或类似数据库表的数据源）结合Groovy语言的模板语言生成你想要的任何东西，如Java代码、C/C++代码、或者SQL等等。

GenThemAll 的Maven Plugin已经基本完成，现在已经能正确地生成想要的东西，使用已经比过往版本简单多了。

	<build>
		<plugins>
			<plugin>
				<groupId>com.ii2d</groupId>
				<artifactId>genthemall-maven-plugin</artifactId>
				<version>0.5.0</version>
				<configuration>
					<!-- 数据源配置 -->
					<databaseSource>
						<driverClassName>${dataSource.driver}</driverClassName>
						<url>${dataSource.url}</url>
						<username>${dataSource.username}</username>
						<password>${dataSource.password}</password>
						<!-- 数据源的表，用","分隔 -->
						<tables>user,shop,product</tables>
					</databaseSource>
					<generateConfigs>
						<!-- 生成表用到的模板 -->
						<generateConfig>
							<tables>user,shop,product</tables>
							<includeTemplate>sqlmap-mysql.*,mybatis-config,commons-model</includeTemplate>
						</generateConfig>
						<generateConfig>
	  					<tables>user</tables>
							<includeTemplate>web-controller</includeTemplate>
						</generateConfig>
					</generateConfigs>
				</configuration>
			</plugin>
		</plugins>
	</build>

*通过以上配置就可以使用以下命令生成代码:*

	mvn genthemall:generate

*0.5.0 版本增加初始化命令，初始化命令能通过配置初始化的模板，生成初始化文件，命令如下:*

	mvn genthemall:init

*查看模板列表命令:*

	mvn genthemall:list
