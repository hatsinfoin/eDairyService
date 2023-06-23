package com.eDairy.services.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eDairy.services.model.NoticeBoardDetails;
import com.eDairy.services.repository.NoticeBoardRepo;

@Service
public class NoticeBoardService {

	@Autowired
	NoticeBoardRepo noticeBoardRepo;

	public List<NoticeBoardDetails> getAllNotices() {
    	System.out.println(" in NoticeBoardService  getAllNotices");

    	List<NoticeBoardDetails>  l = noticeBoardRepo.findAll(); 
    	System.out.println(" in NoticeBoardService  getAllNotices");
    	System.out.println(" in NoticeBoardService  list "+l);

		return l;
	}

	public NoticeBoardDetails saveNoticeBoard(NoticeBoardDetails noticeBoardDetails) {
		return noticeBoardRepo.save(noticeBoardDetails);
	}
}
