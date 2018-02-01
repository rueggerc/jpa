package com.rueggerllc.hibernate;

import org.hibernate.dialect.DerbyTenSevenDialect;

public class MyDerbyDialect extends DerbyTenSevenDialect {

	@Override
	public String getSequenceNextValString(String sequenceName) {
		return "values next value for " + sequenceName;
	}
	
}
