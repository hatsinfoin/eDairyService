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
		return noticeBoardRepo.findAll();
	}

	public NoticeBoardDetails saveNoticeBoard(NoticeBoardDetails noticeBoardDetails) {
		return noticeBoardRepo.save(noticeBoardDetails);
	}
}
