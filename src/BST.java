import java.util.Scanner;

public class BST {
	private static BNode root=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST bst=new BST();
		Scanner scanner=new Scanner(System.in);
	
		while(scanner.hasNext()){
			bst.insert(scanner.nextInt());
		}
		bst.print(root);

	}
	//中序遍历二叉树(打印)
	public void print(BNode T){
		if(T!=null){
			print(T.getLc());
			System.out.println(T.getData());
			print(T.getRc());
		}
	}
	
	//向二叉排序树中插入节点（构造二叉链表）
	/**
	 * @param data 插入的元素
	 * @return
	 */
	public BNode insert(int data){
		//新节点
	    BNode newNode=new BNode(data);
		//当前指针
		BNode current=root;
		//父指针
		BNode parent=root;
		//当前树为空
		if(current==null){
			root=newNode;
			return newNode;
		}
		while(true){
			parent=current;
			if(data<current.getData()){
				current=current.getLc();
				if(current==null){
					parent.setLc(newNode);
					return newNode;
				}
			}
			else if(data>current.getData()){
				current=current.getRc();
				if(current==null){
					parent.setRc(newNode);
					return newNode;
				}
			}
		}
	}
}

//二叉树节点
class BNode{
	private Integer data;
	private BNode lc;
	private BNode rc;
	public BNode(Integer data){
		this.data=data;
		lc=null;
		rc=null;
	}
	public Integer getData() {
		return data;
	}
	public void setData(Integer data) {
		this.data = data;
	}
	public BNode getLc() {
		return lc;
	}
	public void setLc(BNode lc) {
		this.lc = lc;
	}
	public BNode getRc() {
		return rc;
	}
	public void setRc(BNode rc) {
		this.rc = rc;
	}
}
