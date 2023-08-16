package com.marketdongnae.service.Community;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.marketdongnae.domain.community.CategoryDTO;
import com.marketdongnae.domain.community.CommentDTO;
import com.marketdongnae.domain.community.CommunityAllDTO;
import com.marketdongnae.domain.community.HeartDTO;
import com.marketdongnae.domain.community.communityDetailDTO;





public interface CommunityService {
	//글 리스트
	public List<CommunityAllDTO> communityAll();
	//글상세보기
	public CommunityAllDTO communityDetail(String mu_id);
	//조회수 증가
	public void  updateCount(String mu_id);
	//글쓰기
	public void insertCommunity(communityDetailDTO community);
	//수정하기
	public void updateCommunity(communityDetailDTO community);
	// 삭제하기
	public  void deleteCommunity(int mu_id);
	//좋아요
	public HeartDTO heartview(@Param("m_number") String m_number,@Param("mu_id") String mu_id);
	
	public int insertHeart(HeartDTO heart);
	
	public void insertComment (CommentDTO insertComment);
	
	public List<CommentDTO> selectComment(int mu_id);
	public void updateComment (CommentDTO updateComment);
	public void deleteComment(CommentDTO deleteComment);
	
	
	public int counts() ;
	public List<CommunityAllDTO> listPage(@Param("displayPost")int displayPost,@Param("postNum") int postNum);
	public List<CommunityAllDTO> listPageSearch(@Param("displayPost") int displayPost,@Param("postNum")int postNum
			   ,@Param("searchType")String searchType,@Param("keyword") String keyword);
	public int listPageSearchCount(@Param("searchType")String searchType,@Param("keyword") String keyword);
	
	public List<CommunityAllDTO> pageCategory(@Param("displayPost") int displayPost,
											  @Param("postNum")int postNum,
											  @Param("ca_l") String ca_l);
	
	public int pageCategoryCount (String ca_l);
	
	public List<CategoryDTO> category();
}
