/*
 * Copyright 2010-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.cassandra.test.integration.table;

import java.util.Date;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.CassandraType;

import com.datastax.driver.core.DataType;

/**
 * This is an example of dynamic table that creates each time new column with Notification timestamp.
 * 
 * By default it is active Notification until user deactivate it. This table uses index on the field active to access in
 * WHERE cause only for active notifications.
 * 
 * @author Alex Shvid
 */
@PrimaryKeyClass
public class NotificationPK {

	/*
	 * Row ID
	 */
	@PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private String username;

	/*
	 * Clustered Column
	 */
	@PrimaryKeyColumn(ordinal = 1)
	@CassandraType(type = DataType.Name.TIMESTAMP)
	private Date time;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
