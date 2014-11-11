DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS friends;
DROP TABLE IF EXISTS quizzes;
DROP TABLE IF EXISTS questions;
DROP TABLE IF EXISTS history;
DROP TABLE IF EXISTS messages;

CREATE TABLE users (UserID TEXT NOT NULL, PasswordHash TEXT NOT NULL, AdminFlag BOOLEAN NOT NULL, Achievements TINYINT UNSIGNED NOT NULL);
CREATE TABLE friends (ID1 TEXT NOT NULL, ID2 TEXT NOT NULL);
CREATE TABLE quizzes (QuizID TEXT NOT NULL, AuthorID TEXT NOT NULL, CreationDateTime TIMESTAMP NOT NULL DEFAULT NOW(), UpdateDateTime TIMESTAMP, QuizType TINYINT UNSIGNED NOT NULL, QuizOptions TINYINT UNSIGNED NOT NULL);
CREATE TABLE questions (QuizID TEXT NOT NULL, QuestionType TINYINT UNSIGNED NOT NULL, QuestionContent TEXT NOT NULL);
CREATE TABLE history (UserID TEXT NOT NULL, QuizID TEXT NOT NULL, TimeTaken INTEGER NOT NULL, TimeDone TIMESTAMP NOT NULL, NumQuestions TINYINT UNSIGNED NOT NULL, NumRight TINYINT UNSIGNED NOT NULL);
CREATE TABLE messages (UserFrom TEXT NOT NULL, UserTo TEXT NOT NULL, MessageType TINYINT UNSIGNED NOT NULL, MessageContent TEXT NOT NULL, TimeSent TIMESTAMP NOT NULL DEFAULT NOW());

/* The following columns are auto-generated on insertion:
	Quizzes: CreationDateTime

The following are the keys for each table:
	Users: UserID
	Friends: ID1, ID2
	Quizzes: QuizID
	Questions: QuizID, QuestionContent
	History: UserID, QuizID, TimeDone
	Messages: UserFrom, UserTo, TimeSent
*/