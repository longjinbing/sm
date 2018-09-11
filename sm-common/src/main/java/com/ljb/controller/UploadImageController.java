package com.ljb.controller;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ljb.Exception.BusinessException;
import com.ljb.entity.UploadFile;
import com.ljb.mapper.UploadFileDao;
import com.ljb.query.UploadFileQuery;
import com.ljb.utils.DateUtils;
import com.ljb.utils.R;

@RestController
@RequestMapping("upload")
public class UploadImageController extends AbstractController {
	
	@Autowired
	private UploadFileDao uploadfileDao;

	@RequestMapping("/image")
	public R image(@RequestParam("file") MultipartFile image,HttpServletRequest request) {
		if(image.getSize()<=10) {
			return R.error(-1, "文件错误");
		}
		String origname=image.getOriginalFilename();
		String serverPath=request.getSession().getServletContext().getRealPath("/");
		String fileName=getUploadNmae();
		String uploadPath="statics"+File.separator+"upload"+File.separator+"image"+File.separator+fileName+"."+getExe(origname);
		String imagePath="/statics/upload/image/"+fileName+"."+getExe(origname);
		File file=new File(serverPath,uploadPath);
		try {
			image.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			// TODO 自动生成的 catch 块
			throw new BusinessException("上传失败");
		}
		record(image, imagePath);
		return R.ok().put("imgurl", imagePath);
	}
	
	@RequestMapping("deleteimage")
	public R deleteImage(@RequestParam("path") String path,HttpServletRequest request) {
		if(path.length()<=0) {
			return R.error("文件路径出错,无法删除");
		}
		String serverPath=request.getSession().getServletContext().getRealPath(path);
		File file=new File(serverPath);
		if(file.exists()) {
			file.delete();
		}
		UploadFileQuery query=new UploadFileQuery();
		query.createCriteria().andurlEqualTo(path);
		uploadfileDao.deleteByQuery(query);
		return R.ok("删除成功");
	}
	
	public String getUploadNmae() {
		Random random=new Random();
		return DateUtils.uploadTime()+random.nextInt(10000);
	}
	
	public String getExe(String fileName) {
		return fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;		 
	}
	
	public void record(MultipartFile file,String filePath) {
		UploadFile uploadfile=new UploadFile();
		uploadfile.setCreateTime(DateUtils.currentTime());
		uploadfile.setSize((int) file.getSize());
		uploadfile.setExt(getExe(file.getName()));
		uploadfile.setUrl(filePath);
		uploadfile.setType("图片");
		uploadfileDao.insert(uploadfile);
	} 
	
}
