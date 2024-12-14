package initializeDB.service;

import initializeDB.dao.InitializeDBDao;

public class InitializeDBService {
	public void InitializeDB() {
		InitializeDBDao dao = new InitializeDBDao();
		dao.createDB();
		dao.InsertEntries();
	}
}
