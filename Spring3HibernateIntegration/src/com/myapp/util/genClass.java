package com.myapp.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class genClass {

	private static String dao="Item";
	private static String daom="item";
	private static String url="src/com/myapp";
	public static void main(String[] args) throws IOException {
		//createModel();
		//createDao();
		createDaoImpl();
		createService();
		createServiceImpl();
		createController();

	}

	private static void createController() throws IOException{
		File file = new File("src/com/myapp/controller/"+dao+"Controller.java");
		String texto="package com.myapp.controller;\n" + 
				"\n" + 
				"import java.util.List;\n" + 
				"\n" + 
				"import org.springframework.beans.factory.annotation.Autowired;\n" + 
				"import org.springframework.stereotype.Controller;\n" + 
				"import org.springframework.web.bind.annotation.RequestMapping;\n" + 
				"import org.springframework.web.bind.annotation.RequestMethod;\n" + 
				"import org.springframework.web.bind.annotation.ResponseBody;\n" + 
				"\n" + 
				"import com.myapp.entity."+dao+";\n" + 
				"import com.myapp.service."+dao+"Service;\n" + 
				"\n" + 
				"@Controller\n" + 
				"public class "+dao+"Controller {\n" + 
				"\n" + 
				"	@Autowired\n" + 
				"	private "+dao+"Service "+daom+"Service;      \n" + 
				"	@RequestMapping(value = \"/"+daom+"List\", method = RequestMethod.GET, produces=\"application/json\")\n" + 
				"	public @ResponseBody List getAll"+dao+"() {\n" + 
				"		System.out.println(\"#########getAll()#########\");\n" + 
				"		List<"+dao+"> "+daom+"List = "+daom+"Service.findAll();\n" + 
				"		return "+daom+"List;\n" + 
				"	}\n" + 
				"	\n" + 
				"}";
		//Write Content
		FileWriter writer = new FileWriter(file);
		writer.write(texto);
		writer.close();				
	}
			
	
	private static void createModel() throws IOException{
		File file = new File("src/com/myapp/entity/"+dao+".java");
		String texto = "package com.myapp.entity;\n" + 
				"\n" + 
				"import javax.persistence.Column;\n" + 
				"import javax.persistence.Entity;\n" + 
				"import javax.persistence.GeneratedValue;\n" + 
				"import javax.persistence.GenerationType;\n" + 
				"import javax.persistence.Id;\n" + 
				"import javax.persistence.Table;\n" + 
				"\n" + 
				"\n" + 
				"@Entity(name='"+dao+"')\n" + 
				"@Table(name='"+dao+"')\n" + 
				"\n" + 
				"public class "+dao +" {\n" + 
				"	@Id\n" + 
				"	@GeneratedValue(strategy = GenerationType.AUTO)\n" + 
				"	private Long id;\n" + 
				"	@Column(name=\"name\")\n" + 
				"	private String nom;\n" + 
				"	@Column(name=\"description\")\n" + 
				"	private String description;\n" + 
				"	@Column(name=\"price\")\n" + 
				"	private String price;"
				+ "}";
					
		//Write Content
		FileWriter writer = new FileWriter(file);
		writer.write(texto);
		writer.close();		
	}
	
	private static void createService() throws IOException{


		File file = new File("src/com/myapp/service/"+dao+"Service.java");
		  
		String texto = "package com.myapp.service;\n" + 
				"\n" + 
				"import java.util.List;\n" + 
				"\n" + 
				"import com.myapp.entity."+dao+";\n" + 
				"\n" + 
				"public interface "+dao+"Service {\n" + 
				"\n" + 
				"	"+dao+" findById(long Id);\n" + 
				"\n" + 
				"	List<"+dao+"> findAll();\n" + 
				"\n" + 
				"	void add"+dao+"("+dao+" "+daom+");\n" + 
				"\n" + 
				"	void delete"+dao+"(long Id);\n" + 
				"	\n" + 
				"	void update"+dao+"("+dao+" "+daom+");\n" + 
				"\n" + 
			    "}";
					
		//Write Content
		FileWriter writer = new FileWriter(file);
		writer.write(texto);
		writer.close();		
	}

	private static void createServiceImpl() throws IOException{
		File file = new File("src/com/myapp/service/"+dao+"ServiceImpl.java");
		String texto = "package com.myapp.service;\n" + 
				"\n" + 
				"import java.util.List;\n" + 
				"\n" + 
				"import javax.transaction.Transactional;\n" + 
				"\n" + 
				"import org.springframework.beans.factory.annotation.Autowired;\n" + 
				"import org.springframework.stereotype.Service;\n" + 
				"\n" + 
				"import com.myapp.dao."+dao+"Dao;\n" + 
				"import com.myapp.entity."+dao+";\n" + 
				"import com.myapp.service."+dao+"Service;\n" + 
				"\n" + 
				"@Service\n" + 
				"@Transactional\n" + 
				"public class "+dao+"ServiceImpl implements "+dao+"Service { \n" + 
				"\n" + 
				"	@Autowired\n" + 
				"	private "+dao+"Dao "+daom+"Dao;\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public "+dao+" findById(long Id) { \n" + 
				"\n" + 
				"		return "+daom+"Dao.findById(Id);\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	\n" + 
				"	public List<"+dao+"> findAll() {\n" + 
				"		return "+daom+"Dao.findAll();\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"\n" + 
				"	public void add"+dao+"("+dao+" "+daom+") {\n" + 
				"		"+daom+"Dao.add"+dao+"("+daom+");\n" + 
				"\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void delete"+dao+"(long Id) {\n" + 
				"		"+daom+"Dao.delete"+dao+"(Id);\n" + 
				"\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void update"+dao+"("+dao+" "+daom+") {\n" + 
				"		"+daom+"Dao.update"+dao+"("+daom+");\n" + 
				"		\n" + 
				"	}\n" + 
				"\n" + 
				"}\n"; 
		//Write Content
		FileWriter writer = new FileWriter(file);
		writer.write(texto);
		writer.close();		
		
	}
	
	private static void createDao() throws IOException{
		
		File file = new File("src/com/myapp/dao/"+dao+"Dao.java");
		  
		String texto = "package com.myapp.dao;\n" + 
				"\n" + 
				"import java.util.List;\n" + 
				"\n" + 
				"import com.myapp.entity."+dao+";\n" + 
				"\n" + 
				"public interface "+dao+"Dao {\n" + 
				"\n" + 
				"	"+dao+" findById(long Id);\n" + 
				"\n" + 
				"	List<"+dao+"> findAll();\n" + 
				"\n" + 
				"	void add"+dao+"("+dao+" "+daom+");\n" + 
				"\n" + 
				"	void delete"+dao+"(long Id);\n" + 
				"	\n" + 
				"	void update"+dao+"("+dao+" "+daom+");\n" + 
				"\n" + 
			    "}";
					
		//Write Content
		FileWriter writer = new FileWriter(file);
		writer.write(texto);
		writer.close();		
	}
	private static void createDaoImpl() throws IOException{
		
		
		File file = new File("src/com/myapp/dao/"+dao+"DaoImpl.java");
		  
		String texto = "package com.myapp.dao;\n" + 
				"\n" + 
				"import java.util.List;\n" + 
				"\n" + 
				"import org.hibernate.SessionFactory;\n" + 
				"import org.springframework.beans.factory.annotation.Autowired;\n" + 
				"import org.springframework.stereotype.Repository;\n" + 
				"\n" + 
				"import com.myapp.entity."+dao+";\n" + 
				"\n" + 
				"@Repository\n" + 
				"public class "+dao+"DaoImpl implements "+dao+"Dao{\n" + 
				"\n" + 
				"	@Autowired\n" + 
				"    private SessionFactory sessionFactory;\n" + 
				"\n" + 
				"@Override\n" + 
				"				public "+dao+" findById(long Id) {\n" + 
				"					"+dao+" "+daom+" = ("+dao+") sessionFactory.getCurrentSession().get("+dao+".class, Id);\n" + 
				"					return "+daom+";\n" + 
				"				}"+
				"\n" + 
				"	@Override\n" + 
				"	public List<"+dao+"> findAll() {\n" + 
				"		 return sessionFactory.getCurrentSession().createQuery(\"from \"+dao+\").list(); \n" + 
				"	}\n" + 
				"	@Override\n" + 
				"	public void add"+dao+"("+dao+" "+daom+") {\n" + 
				"		sessionFactory.getCurrentSession().save("+daom+");\n" + 
				"		\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void delete"+dao+"(long Id) {\n" + 
				"		"+dao+" "+daom+" = ("+dao+") sessionFactory.getCurrentSession().load("+dao+".class, Id); \n" + 
				"        if (null != "+daom+") {\n" + 
				"            sessionFactory.getCurrentSession().delete("+daom+");\n" + 
				"        }\n" + 
				"		\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void update"+dao+"("+dao+" "+daom+") {\n" + 
				"		sessionFactory.getCurrentSession().update("+daom+");\n" + 
				"		\n" + 
				"	}"+
				"}";
					
		//Write Content
		FileWriter writer = new FileWriter(file);
		writer.write(texto);
		writer.close();
		
	}

}
