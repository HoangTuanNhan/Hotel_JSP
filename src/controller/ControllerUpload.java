package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

/**
 * Servlet implementation class ControllerUpload
 */
public class ControllerUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerUpload() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println( request.getServletContext().getRealPath(""));
		
		String ten = "";
		String tuoi = "";
		String tenhinh = "";
		
		//lấy tất cả các phần tử của form
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		try {
			List<FileItem> formItems = upload.parseRequest(request);
			for (FileItem formItem : formItems) {
				
					if(!formItem.isFormField()){
						tenhinh = formItem.getName();
						
						//upload hình lên thư mục files
						////đổi tên hình: a3.jpg => a3-3232322.jpg
						String tenhinh_moi = FilenameUtils.getName(tenhinh) 
								+ "_" + System.nanoTime() + "." + 
								FilenameUtils.getExtension(tenhinh);
						
						
						String pathname = request.getServletContext().getRealPath("") + File.separator + "files" + File.separator + tenhinh_moi;
						File file = new File(pathname);
						formItem.write(file);
						
						//đường dẫn URL file
						String url = request.getContextPath() + "/files/" + tenhinh_moi;
						request.setAttribute("url", url);
					}
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//in ra
	
		System.out.println("Pic: " + tenhinh);
		
		RequestDispatcher rd = request.getRequestDispatcher("/upload.jsp");
		rd.forward(request, response);
		
	}

}
