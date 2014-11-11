package website;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
	private Connection db;
	private Statement stmt;
	
	public DBConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			String account = MyDBInfo.MYSQL_USERNAME;
			String server = MyDBInfo.MYSQL_DATABASE_SERVER;
			String password = MyDBInfo.MYSQL_PASSWORD;
			db = DriverManager.getConnection("jdbc:mysql://" + server, account, password);
			
			String database = MyDBInfo.MYSQL_DATABASE_NAME;
			stmt = db.createStatement();
			stmt.executeQuery("USE " + database + ";");
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void exit(){
		try {
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Methods accessing the users database
	 */
	public User getInfo(String userID){
		return new User();
	}
	
	/*
	 * Methods accessing the friends database
	 */
	public List<String> getFriends(String userID){
		return new ArrayList<String>();
	}
	
	/*
	 * Methods accessing the quizzes database
	 */
	
	public List<Quiz> getQuizzesBy(String quizID){
		return new ArrayList<Quiz>();
	}
	
	public List<Quiz> popularQuizzes(){
		return new ArrayList<Quiz>();
	}
	
	public List<Quiz> recentlyCreatedQuizzes(){
		return new ArrayList<Quiz>();
	} 
	
	public List<Quiz> recentlyCreatedQuizzes(String userID){
		return new ArrayList<Quiz>();
	} 
	
	public List<Quiz> recentlyTakenQuizzes(){
		return new ArrayList<Quiz>();
	}
	
	public List<Quiz> recentlyTakenQuizzes(String userId){
		return new ArrayList<Quiz>();
	}
	
	/*
	 * Methods accessing the questions database
	 */
	
	public List<Question> getQuestions(String quizID){
		return new ArrayList<Question>();
	}
	
	/*
	 * Methods accessing the history database
	 */
	
	public List<History> getPersonalHistory(String userID, String quizID){
		return new ArrayList<History>();
	}
	
	public List<History> getTopScores(String quizID){
		return new ArrayList<History>();
	}
	
	public List<History> getTopScoresInDay(String quizID){
		return new ArrayList<History>();
	}
	
	public List<History> getRecentScores(String quizID){
		return new ArrayList<History>();
	}
	
	/*
	 * Methods accessing the messages database
	 */
	
	public List<Message> getMessagesTo(String userID){
		return new ArrayList<Message>();
	}
	
	public List<Message> getMessagesFrom(String userID){
		return new ArrayList<Message>();
	}
	
	/*
	 * Methods involving searching multiple tables
	 */
	
	public List<String> getRecentActivity(String userID){
		return new ArrayList<String>();
	}
}
