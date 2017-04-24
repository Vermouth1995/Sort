package graphic;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Show extends JFrame {

	private static final long serialVersionUID = 1L;
	/** 要排列的数列 */
	private int[] sortInt;
	/** 是否需要重绘 */
	private boolean[] need;
	/** 正在遍历的列 */
	private int inUse = 0;
	/** 最高列 */
	private int max = 0;

	/**
	 * 获得index处的值
	 *
	 * @param index
	 * @return
	 */

	public int get(int index) {
		times++;
		return sortInt[index];
	}

	/**
	 * 获得数组长度。
	 *
	 * @return
	 */
	public int length() {
		return max + 1;
	}

	/**
	 * 设置值。
	 *
	 * @param index
	 * @param value
	 */
	public void set(int index, int value) {
		inUse = index;
		times++;
		sortInt[index] = value;
		need[index] = true;
		paint(getGraphics());
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** 操作数 */
	private int times = 0;
	/** 算法名称 */
	private String name = "";

	public Show(int len, String name) {
		sortInt = new int[len];
		need = new boolean[len];
		if (name != null) {
			this.name = name;
		}
		max = len - 1;
		List<Integer> li = new ArrayList<>();
		for (int i = 0; i < sortInt.length; i++) {
			li.add(new Integer(i));
		}
		for (int i = 0; i < sortInt.length; i++) {
			sortInt[i] = li.remove((int) (Math.random() * li.size()));
			need[i] = true;
		}
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setSize(1350, 600);
		setLocationRelativeTo(null);
		setVisible(true);
        paint(getGraphics());
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 绘图
	 */
	@Override
	public void paint(Graphics g) {
		int wide = (getSize().width - 100) / sortInt.length;
		for (int i = 0; i < sortInt.length; i++) {
			if (need[i]) {
				if (i == inUse) {
					g.setColor(Color.RED);
				} else {
					g.setColor(Color.GRAY);
					need[i] = false;
				}
				g.clearRect(i * wide + 50, 0, wide, getSize().height);
				g.fillRect(i * wide + 50, getSize().height
						- (getSize().height - 100) * sortInt[i] / max - 50,
						wide, (getSize().height - 100) * sortInt[i] / max);
			}
		}
		setTitle(name + "    运算次数：" + times);
	}

	public int getTimes() {
		return times;
	}

	public String getSortName() {
		return this.name;
	}
	public boolean ok(){
		for (int i = 0; i < max; i++) {
			if (get(i)>get(i+1)) {
				return false;
			}
		}
		return true;
	}

}
