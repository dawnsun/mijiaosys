Mybatis generator使用说明

作用：
	同步RDS日常环境表结构到本地，自动更新mybatis相关类及配置文件。

方法：

	1.命令行cd到generatorConfig.xml文件所在目录下。
	2.执行java -jar mybatis-generator-core-1.3.2.jar -configfile generatorConfig.xml -overwrite
	3.命令执行后，提示"MyBatis Generator finished successfully"表示同步成功。
	
说明：
	1.mybatis-generator-core-1.3.2.jar 为Mybatis generator工具包。
	2.mysql-connector-java-5.1.30.jar 为连接数据库所需的驱动。