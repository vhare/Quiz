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
	
	/* In cases where we are returning a limited number of entries
	 * The number returned is arbitrarily set at 10
	 * Examples uses: top scores, most recently created/taken quizzes, etc.
	 */
	private int entryLimit = 10;
	
	/* Initializer- establishes a connection to the database
	 * It is assumed to be persistent during the operation of the website
	 */
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
	
	//Closes the connection to the server
	public void exit(){
		try {
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Methods involving the users database
	 */
	
	public boolean usernameTaken(String userID){
		return true;
	}
	
	//Returns all of the info for a single user identified by their ID
	public User getInfo(String userID){
		return new User();
	}
	
	//Adds a given user to the database; returns true on success, false on failure
	public boolean createUser(User user){
		return true;
	}
	
	//Updates the userID in the database to match the one provided; returns true on success, false on failure
	public boolean editUsers(User user){
		return true;
	}
	
	//Removes a given user from the database; returns true on success, false on failure
	private boolean removeUserAccount(String userID){
		return true;
	}
	
	/*
	 * Methods accessing the friends database
	 */
	
	//Returns a list of all of the friends of a given user identified by their ID
	public List<String> getFriends(String userID){
		return new ArrayList<String>();
	}
	
	//Adds a given pair of users as friends; return true on success, false on failure
	public boolean addFriends(String ID1, String ID2){
		return true;
	}
	
	//Removes two users as friends; returns true on success, false on failure
	public boolean removeFriends(String ID1, String ID2){
		return true;
	}
	
	/*
	 * Methods accessing the quizzes database
	 */
	
	public boolean quizNameTake(String quizID){
		return true;
	}
	
	//Returns the quiz identified by a given ID 
	public Quiz getQuiz(String quizID){
		return new Quiz();
	}
	
	//Returns the 10 quizzes taken most often
	public List<Quiz> popularQuizzes(){
		return new ArrayList<Quiz>();
	}
	
	//Returns the 10 most recently created quizzes
	public List<Quiz> recentlyCreatedQuizzes(){
		return new ArrayList<Quiz>();
	} 
	
	//Returns 10 quizzes most recently created by a given user
	public List<Quiz> recentlyCreatedQuizzes(String userID){
		return new ArrayList<Quiz>();
	} 
	
	//Returns the 10 most recently taken quizzes
	public List<Quiz> recentlyTakenQuizzes(){
		return new ArrayList<Quiz>();
	}
	
	//Returns the 10 quizzes most recently taken by a given user
	public List<Quiz> recentlyTakenQuizzes(String userId){
		return new ArrayList<Quiz>();
	}
	
	//Adds a given quiz to the database; returns true on success, false on failure
	public boolean addQuiz(Quiz quiz){
		return true;
	}
	
	//Edits a given quiz; returns true on success, false on failure
	public boolean editQuiz(Quiz quiz){
		return true;
	}
	
	//Removes a given quiz; returns true on success, false on failure
	private boolean removeQuizDB(String quizID){
		return true;
	}
	
	/*
	 * Methods accessing the questions database
	 */
	
	//Returns all of the questions for a given quiz
	public List<Question> getQuestions(String quizID){
		return new ArrayList<Question>();
	}
	
	//Adds a question; returns true on success, false on failure
	public boolean addQuestion(Question question){
		return true;
	}

	//Removes all previous questions for a given quiz, then adds the new ones; returns true on success, false on failure
	public boolean editQuestions(String quizID, List<Question> questions){
		return true;
	}
	
	//Removes a single question; returns true on success, false on failure
	public boolean removeQuestion(Question question){
		return true;
	}
	
	//Removes all questions associated with a given quiz; returns true on success, false on failure
	private boolean removeQuestions(String quizID){
		return true;
	}
	
	/*
	 * Methods accessing the history database
	 */
	
	//Returns all quiz scores every achieved by a user
	public List<History> getPersonalHistory(String userID, String quizID){
		return new ArrayList<History>();
	}
	
	//Returns the 10 all time top scores achieved on a given quiz
	public List<History> getTopScores(String quizID){
		return new ArrayList<History>();
	}
	
	//Returns the top 10 scores on a given quiz in a day
	public List<History> getTopScoresInDay(String quizID){
		return new ArrayList<History>();
	}
	
	//Returns the 10 most recent scores on the quiz
	public List<History> getRecentScores(String quizID){
		return new ArrayList<History>();
	}
	
	//Adds a history item; returns true on success, false on failure
	public boolean addScore(History history){
		return true;
	}
	
	//Removes all scores for a given quiz; returns true on success, false on failure
	private boolean removeScoresByQuiz(String quizID){
		return true;
	}
	
	//Removes all scores by a given user; returns true on success, false on failure
	private boolean removeScoresByUser(String userID){
		return true;
	}
	
	/*
	 * Methods accessing the messages database
	 */
	
	//Returns all messages to a given user
	public List<Message> getMessagesTo(String userID){
		return new ArrayList<Message>();
	}
	
	//Returns all messages from a given user
	public List<Message> getMessagesFrom(String userID){
		return new ArrayList<Message>();
	}
	
	//Adds a message to the database; returns true on success, false on failure
	public boolean addMessage(Message message){
		return true;
	}
	
	//Removes a message from the database; returns true on success, false on failure
	public boolean removeMessage(Message message){
		return true;
	}
	
	//Removes all messages to/from a given user; returns true on success, false on failure
	private boolean removeAllMessages(User user){
		return true;
	}
	
	/*
	 * Methods involving multiple tables
	 */
	
	//Returns the 10 most recent activities that have occurred on the website
	public List<String> getRecentActivity(String userID){
		return new ArrayList<String>();
	}
	
	//Removes a given user, their messages, their history, and their quizzes
	//Returns true on success, false on failure
	public boolean removeUser(User user){
		return true;
	}
	
	//Removes a given quiz, all associated histories, and all associated questions
	//Returns true on success, false on failure
	public boolean removeQuiz(Quiz quiz){
		return true;
	}
}
