package lessons.welcome.methods.picture;

import plm.universe.bugglequest.SimpleBuggle;

public class PictureMono3Entity extends SimpleBuggle {

	/* BEGIN TEMPLATE */
	public void run() {
		/* BEGIN SOLUTION */
		for (int i=0; i<9; i++) {
			makeLine(9);
			nextLine();
		}
	}
	void mark() {
		brushDown();
		brushUp();
	}

	void makeV() {
		forward();
		mark();

		forward();
		left();
		forward();
		mark();

		backward();
		right();
		forward();
		mark();

		forward();
		left();
	}

	void makePattern() {
		makeV();
		makeV();
		makeV();
		makeV();
		forward(5);
	}

	void makeLine(int count){
		for (int i=0; i<count;i++)
			makePattern();
		backward(count*5);
	}

	void nextLine() {
		left();
		forward(5);
		right();	
		/* END SOLUTION */
	}
	/* END TEMPLATE */
}
