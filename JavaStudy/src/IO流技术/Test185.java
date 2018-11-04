package IO������;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * ������
 * д�����ȡ
 * ����˳����д��˳��һ��
 * ���ǲ������඼�������л���Ҫ Serializable
 * ObjectOutputStream()
 * ObjectInputStream()
 * @author jie
 *
 */
public class Test185 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		demo1();
	}
	//�ֽ�������
	private static void demo1() throws IOException, ClassNotFoundException {
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(new BufferedOutputStream(baos));
		oos.writeUTF("�Ұ���");
		oos.writeByte(1);
		oos.writeChar('a');
		oos.writeObject("���");
		oos.writeObject(new Date());
		oos.writeObject(new Employee("����", 400));
		//�ǵ�ǿ��ˢ��
		oos.flush();
		byte[] datas=baos.toByteArray();
		ObjectInputStream ois=new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		System.out.println(ois.readUTF());
		System.out.println(ois.readByte());
		System.out.println(ois.readChar());
		Object str=ois.readObject();
		Object date=ois.readObject();
		Object employee=ois.readObject();
		
		if(str instanceof String) {
			System.out.println(str);
		}
		if(date instanceof Date) {
			System.out.println(date);
		}
		if(employee instanceof Employee) {
			System.out.println(employee);
		}

	}
}
//javabean ��װ��
class Employee implements Serializable{
	private String name;
	private  transient double salary;
	
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double  getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}
	
}
