package service;

import java.util.List;

import model.Listofnotes;
import model.Note;
import model.PageBean;
import model.Replynote;

public interface WebbookService {
	
	public List<Note> getAllNotes();    //查询所有主题帖子，按时间降序 
	
	public void insertMainNotes(String mainNoteType, String mainNoteTitle, String mainNoteContent, String username);//添加主题帖
	
	public PageBean<Note> findByPage(int pc);//分页查询主题帖；按时间降序；
	
	public PageBean<Replynote> findReplyNoteByPage(int pc, int id);//分页查询主题帖下的帖子集合。
	
	public PageBean<Listofnotes> findRecentReplyByPage(int pc);//通过页码查询内容，新的！！！！
	
	public Note getMainNote(int id);//获取主题帖子的内容（不包括回复内容）;
	
	public void  insertReplyNotes(int id, String floorcontent, String username);//插入回复的帖子；根据主题帖子的id,,这是不含引用的回复！！
	
	public Replynote findReplyNote(int id);//查询单独回复内容，用作引用的内容。
	
	public PageBean<Note> findByFuzzyPage(int pc, String str);//模糊查询
	
	public void deleteMainNote(int id);//根据主题帖id删除整个主题帖包括回复。
	
	public void deleteReplyNote(int id);//根据reply note表的id删除回复。

}
