package IO流技术;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/*
 * 面向对象，封装切割文件
 * 合并文件
 */
public class Test188 {
	//源
	private File file;
	//目的文件目录
	private String destDir;
	//所有分割后的文件存储路径
	private List<String> destPaths;
	//每块大小
	int blockSize;
	//块数
	int num;
	
	public Test188(String file, String destDir) {
		 this(file, destDir,1024*1024*10);
	}
	
	public Test188(String file, String destDir, int blockSize) {
		this.file = new File(file);
		this.destDir = destDir;
		this.blockSize = blockSize;
		this.destPaths=new ArrayList<String>();
		init();
	}
	
	private void init() {
		this.num=(int)Math.ceil(file.length()*1.0/blockSize);
		for(int i=0;i<this.num;i++) {
			this.destPaths.add(this.destDir+"/"+i+"_"+this.file.getName());
		}
	}
	
	public void split() throws IOException {
		//总长度
		long len=file.length();
		//开始位置
		int beginPos=0;
		//每块的实际长度
		int actualSize=0;		
		for(int i=0;i<num;i++) {
			beginPos=i*blockSize;
			if(i==num-1) {
				actualSize=(int) len;
			}else {
				actualSize=blockSize;
				len-=blockSize;
			}
			splitDetail(i, beginPos, actualSize);
		}

	}
	private void splitDetail(int i,int beginPos,int actualSize) throws IOException{
		RandomAccessFile raf=new RandomAccessFile(file, "r");
		RandomAccessFile raf2=new RandomAccessFile(destPaths.get(i), "rw");
		raf.seek(beginPos);
		int len=-1;
		byte[] flush=new byte[1024];
		while((len=raf.read(flush))!=-1) {
			if(actualSize>len) {
				raf2.write(flush, 0, len);
				actualSize-=len;
			}else {
				raf2.write(flush, 0, actualSize);
				break;
			}
		}
		raf2.close();
		raf.close();
	}
	//合并
    //	SequenceInputStream
	public  void  merge(String destPath) throws IOException {
		OutputStream os=new BufferedOutputStream(new FileOutputStream(destPath, true));
		SequenceInputStream sis=null;
		Vector<InputStream> vector=new Vector<>();
		for(int i=0;i<destPaths.size();i++) {
			vector.add(new BufferedInputStream(new  FileInputStream(destPaths.get(i))));
		}
		sis=new SequenceInputStream(vector.elements());
		byte[] flush=new byte[1024];
		int len=-1;
		while((len=sis.read(flush))!=-1) {
			os.write(flush, 0, len);
		}
		os.flush();
		sis.close();
		os.close();
	}

	public static void main(String[] args) throws IOException {
		Test188 split=new Test188("src/IO流技术/开篇.mp4", "src/IO流技术/splitVideo");
		split.split();
		split.merge("src/IO流技术/splitVideo/merge.mp4");
	}
}
