package com.cassandra.javaConnect;

/**
 * @author Vishnu Prabhakar
 * Main program to connect with cassandra instance
 *
 */
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class App {

	public static void main(String[] args) {
		String serverIp = "127.0.0.1";
		/**
		 * create keyspace in cassandra using the query: CREATE KEYSPACE test WITH
		 * replication = {'class': 'SimpleStrategy', 'replication_factor': '3'} AND
		 * durable_writes = true;
		 */
		String keyspace = "test";

		Cluster cluster = Cluster.builder().addContactPoints(serverIp).build();

		Session session = cluster.connect(keyspace);

		/**
		 * create table using the query:CREATE TABLE emp(emp_id int PRIMARY KEY ,
		 * emp_name text);
		 */
		String cqlStatement = "SELECT * FROM my_product_range";
		for (Row row : session.execute(cqlStatement)) {
			System.out.println(row.toString());
		}

		session.close();
	}
}