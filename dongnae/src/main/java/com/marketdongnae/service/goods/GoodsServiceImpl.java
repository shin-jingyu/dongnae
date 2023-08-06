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
	
	private String[] processUpload(MultipartFile[] uploadFile, File uploadPath) {
	    String[] picFileNames = new String[3];
	    for (int i = 0; i < uploadFile.length; i++) {
	        MultipartFile picFile = uploadFile[i];
	        if (picFile != null && !picFile.isEmpty()) {
	            picFileNames[i] = picFile.getOriginalFilename();
	            UUID uuid = UUID.randomUUID();
	            picFileNames[i] = uuid.toString() + "_" + picFileNames[i];
	            log.info("only-file-name" + picFileNames[i]);
	            File saveFile = new File(uploadPath, picFileNames[i]);
	            try {
	                uploadFile[i].transferTo(saveFile);
	            } catch (IllegalStateException e) {
	                e.printStackTrace();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return picFileNames;
	}
	
	
	@Override
	public List<GoodsDTO> getGoodsList() {
		// TODO Auto-generated method stub
		return goodsMapper.getGoodsList();
	}
	
	@Override
	public void processUploadAndInsertGoods(GoodsDTO goodsDTO, MultipartFile[] uploadFile) {
	    String uploaderFolder = "/Users/nohbin/git/dongnaeMarket/dongnae/src/main/webapp/resources/upload";
	    File uploadPath = new File(uploaderFolder, getFolder());
	    log.info("upload path : " + uploadPath);
	    String filePath = uploadPath.toString();

	    if (!uploadPath.exists()) {
	        uploadPath.mkdirs();
	    }
	    log.info("Upload FilePath  : " + filePath);

	    String[] picFileNames = processUpload(uploadFile, uploadPath);

	    goodsDTO.setG_picpath(getFolder());
	    goodsDTO.setG_pic01(picFileNames[0]);
	    goodsDTO.setG_pic01(picFileNames[1]);
	    goodsDTO.setG_pic01(picFileNames[2]);

	    goodsMapper.insertGoods(goodsDTO);
	    
	    
	}

	@Override
	public void processUploadAndUpdateGoods(GoodsDTO goodsDTO, MultipartFile[] uploadFile) {
	    String uploaderFolder = "/Users/nohbin/git/dongnaeMarket/dongnae/src/main/webapp/resources/upload";
	    File uploadPath = new File(uploaderFolder, getFolder());
	    log.info("upload path : " + uploadPath);
	    String filePath = uploadPath.toString();

	    if (!uploadPath.exists()) {
	        uploadPath.mkdirs();
	    }
	    log.info("Upload FilePath  : " + filePath);

	    String[] picFileNames = processUpload(uploadFile, uploadPath);

	    goodsDTO.setG_picpath(getFolder());
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
