package indi.fuhongxue.pattern.construction.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Prototype implements Cloneable, Serializable {

	private static final long serialVersionUID = 1L;
	private int base;
	private Integer obj;
	
	/*ǳ����*/
	public Object clone() throws CloneNotSupportedException {
		// ��ΪCloneable�ӿ��Ǹ��սӿڣ����ǿ������ⶨ��ʵ����ķ�����
		// ��cloneA��cloneB���˴����ص���super.clone()���
		// super.clone()���õ���Object��clone()����
		// ����Object���У�clone()��native(���ط���)��
		Prototype proto = (Prototype) super.clone();
		return proto;
	}
	
	/*���*/
	public Object deepClone() throws IOException, ClassNotFoundException {
		
		/*д�뵱ǰ����Ķ�������*/
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);
		
		/*�������������������¶���*/
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		return ois.readObject();
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public Integer getObj() {
		return obj;
	}

	public void setObj(Integer obj) {
		this.obj = obj;
	}
	
	
}