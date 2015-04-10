package models;

public class Message {


	private String content;
	//private int turn;

    public Message() {
        this.content = "";
    }
    
    public Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    @Override
    public String toString() {
        return this.content;
    }









}
