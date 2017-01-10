package serviceImpl;

import java.util.List;

import dao.WebbookDao;
import daoImpl.WebbookDaoImpl;
import model.Listofnotes;
import model.Note;
import model.PageBean;
import model.Replynote;
import service.WebbookService;

public class WebbookServiceImpl implements WebbookService{

	WebbookDao wb = new WebbookDaoImpl();
	
	@Override
	public List<Note> getAllNotes() {
		// TODO Auto-generated method stub
		return this.wb.getAllNotes();
	}

	@Override
	public void insertMainNotes(String mainNoteType, String mainNoteTitle, String mainNoteContent, String username) {
		// TODO Auto-generated method stub
		try{
			this.wb.insertMainNotes(mainNoteType, mainNoteTitle, mainNoteContent, username);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public PageBean<Note> findByPage(int pc) {
		// TODO Auto-generated method stub
		
			return this.wb.findByPage(pc);

		
	}

	@Override
	public PageBean<Replynote> findReplyNoteByPage(int pc, int id) {
		// TODO Auto-generated method stub
		
			return this.wb.findReplyNoteByPage(pc,id);

	}

	@Override
	public PageBean<Listofnotes> findRecentReplyByPage(int pc) {
		// TODO Auto-generated method stub
		
			return this.wb.findRecentReplyByPage(pc);

	}

	@Override
	public Note getMainNote(int id) {
		// TODO Auto-generated method stub
		
			return this.wb.getMainNote(id);

	}

	@Override
	public void insertReplyNotes(int id, String floorcontent, String username) {
		// TODO Auto-generated method stub
		
			this.wb.insertReplyNotes(id, floorcontent, username);

		
	}

	@Override
	public Replynote findReplyNote(int id) {
		// TODO Auto-generated method stub
		
			return this.wb.findReplyNote(id);

	}

	@Override
	public PageBean<Note> findByFuzzyPage(int pc, String str) {
		// TODO Auto-generated method stub
		
			return this.wb.findByFuzzyPage(pc, str);

	}

	@Override
	public void deleteMainNote(int id) {
		// TODO Auto-generated method stub
		
			this.wb.deleteMainNote(id);

		
	}

	@Override
	public void deleteReplyNote(int id) {
		// TODO Auto-generated method stub
		
			this.wb.deleteReplyNote(id);

		
	}

}
