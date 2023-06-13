package dtree;

import java.util.List;

import weka.core.Instance;

public class Tree {
	List<Tree> children = null;
	int attributeIndex = -1;
	double prediction = Double.NaN;

	public double predict(Instance instance) {
		if (this.isLeaf()) {
			return prediction;
		} else {
			double attributeValue = instance.value(attributeIndex);
			return this.children.get((int) attributeValue).predict(instance);
		}
	}

	public boolean isLeaf() {
		return children == null || children.size() == 0;
	}
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("(");
		if (isLeaf()) {
			b.append("Class: ");
			b.append(prediction);
		} else {
			b.append("Attribute : ");
			b.append(attributeIndex);
			b.append(" ");
			for (int child = 0; child < children.size(); child++) {
				b.append(" ");
				b.append(children.get(child).toString());
			}
		}
		b.append(")");

		return b.toString();
	}
}
