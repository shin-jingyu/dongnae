package com.marketdongnae.service.goods;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.marketdongnae.domain.goods.GoodsDTO;
import com.marketdongnae.mapper.GoodsMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class GoodsServiceImpl implements GoodsService {

	private final GoodsMapper goodsMapper;
	
	private String getFolder() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = simpleDateFormat.format(date);
		return str.replace("-", File.separator);
	}
	
	
	@Override
	public List<GoodsDTO> getList() {
		// TODO Auto-generated method stub
		return goodsMapper.getList();
	}
	
	@Override
	public void processUploadAndInsertGoods(GoodsDTO goodsDTO, MultipartFile[] uploadFile) {
		// TODO Auto-generated method stub
		//mac 기준 경로설정
		String uploaderFolder = "/Users/nohbin/Desktop/upload";
		
		// upload date 별 file 생성
		File uploadPath = new File(uploaderFolder, getFolder());
		log.info("upload path : " + uploadPath);
		String filePath = uploadPath.toString();
		
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		log.info("Upload FilePath  : " + filePath);
		
	    String[] picFileNames = new String[3];

	    // MultipartFile 필드들을 반복문으로 처리로 파일 저장 및 UUID설정으로 중복되는 파일명 처리
	    for (int i = 0; i < uploadFile.length; i++) {
	        MultipartFile picFile = uploadFile[i];
	        if (picFile != null && !picFile.isEmpty()) {
	            // 파일 업로드 처리 로직
	            picFileNames[i] = picFile.getOriginalFilename();
	            UUID uuid = UUID.randomUUID();
	            picFileNames[i] = uuid.toString() + "_" + picFileNames[i];
	            log.info("only-file-name" + picFileNames[i]);
	            File saveFile = new File(uploadPath, picFileNames[i]);
	            try {
	            	uploadFile[i].transferTo(saveFile);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	    } // FOR END
		
	    goodsDTO.setG_picpath(filePath);
	    goodsDTO.setG_pic01(picFileNames[0]);
	    goodsDTO.setG_pic01(picFileNames[1]);
	    goodsDTO.setG_pic01(picFileNames[2]);
	    
	    goodsMapper.insertGoods(goodsDTO);
	}

	@Override
	public void processUploadAndUpdateGoods(GoodsDTO goodsDTO, MultipartFile[] uploadFile) {
		// TODO Auto-generated method stub
		//mac 기준 경로설정
		String uploaderFolder = "/Users/nohbin/Desktop/upload";
		
		// upload date 별 file 생성
		File uploadPath = new File(uploaderFolder, getFolder());
		log.info("upload path : " + uploadPath);
		String filePath = uploadPath.toString();
		
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		log.info("Upload FilePath  : " + filePath);
		
	    String[] picFileNames = new String[3];

	    // MultipartFile 필드들을 반복문으로 처리로 파일 저장 및 UUID설정으로 중복되는 파일명 처리
	    for (int i = 0; i < uploadFile.length; i++) {
	        MultipartFile picFile = uploadFile[i];
	        if (picFile != null && !picFile.isEmpty()) {
	            // 파일 업로드 처리 로직
	            picFileNames[i] = picFile.getOriginalFilename();
	            UUID uuid = UUID.randomUUID();
	            picFileNames[i] = uuid.toString() + "_" + picFileNames[i];
	            log.info("only-file-name" + picFileNames[i]);
	            File saveFile = new File(uploadPath, picFileNames[i]);
	            try {
	            	uploadFile[i].transferTo(saveFile);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	    } // FOR END
		
	    goodsDTO.setG_picpath(filePath);
	    goodsDTO.setG_pic01(picFileNames[0]);
	    goodsDTO.setG_pic01(picFileNames[1]);
	    goodsDTO.setG_pic01(picFileNames[2]);

		
		goodsMapper.updateGoods(goodsDTO);
	}
	
	@Override
	public void updateGoods(GoodsDTO goodsDTO) {
		// TODO Auto-generated method stub
		goodsMapper.updateGoods(goodsDTO);
	}
	
	@Override
	public void insertGoods(GoodsDTO goodsDTO) {
		// TODO Auto-generated method stub
		goodsMapper.insertGoods(goodsDTO);
	}
	

	
	
	

}
