package com.doc_app.persistence;

import java.io.IOException;
import java.sql.SQLException;

import com.doc_app.bean.Admin;

public interface AdminDao  {

	Admin getRecordByaID(int id)throws SQLException, ClassNotFoundException, ClassNotFoundException, IOException;
	
}
