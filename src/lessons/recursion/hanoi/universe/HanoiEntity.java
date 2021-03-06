package lessons.recursion.hanoi.universe;
/* BEGIN TEMPLATE */
import java.io.BufferedWriter;
import java.io.IOException;


import plm.universe.Entity;
import plm.universe.World;

public class HanoiEntity extends Entity {
	/** Instantiation Constructor (used by exercises to setup the world) 
	 * Must call super(name, world). If you had fields to setup, you'd  have to add more parameters
	 */
	public HanoiEntity(String name, World world) {
		/* BEGIN HIDDEN */
		super(name,world);
		/* END HIDDEN */
	}

	/** Part of the copy process 
	 * Must call super(name)
	 */
	public HanoiEntity(String name) {
		/* BEGIN HIDDEN */
		super(name);
		/* END HIDDEN */
	}
	/** Must exist too. Calling HanoiEntity("dummy name") is ok */
	public HanoiEntity() {
		/* BEGIN HIDDEN */
		this("Hanoi Entity");
		/* END HIDDEN */
	}

	/** Must exist so that exercises can instantiate your entity (Entity is abstract) */
	@Override
	public void run() {
	}

	/** Part of your world logic */
	public void move(int src, int dst) {
		/* BEGIN HIDDEN */
		((HanoiWorld) world).move(src,dst);
		stepUI();
		/* END HIDDEN */
	}
	public int getSlotSize(int slot) {
		return ((HanoiWorld) world).getSlotSize(slot);
	}
	
	/* BEGIN HIDDEN */
	@Override
	public String toString(){
		return "HanoiEntity (" + this.getClass().getName() + ")";
	}
	/* END HIDDEN */
	
	
	/* BINDINGS TRANSLATION: French */
	public void deplace(int src,int dst) { move(src, dst); }
	public int  getTaillePiquet(int rank) { return getSlotSize(rank); }

	@Override
	public void command(String command, BufferedWriter out) {
		int num = Integer.parseInt((String) command.subSequence(0, 3));
		int nb,nb2;
		try {
			switch(num){
			case 110:
				nb = Integer.parseInt((command.split(" ")[1]));
				nb2 = Integer.parseInt((command.split(" ")[2]));
				move(nb, nb2);
				break;
			case 111:
				nb = Integer.parseInt((command.split(" ")[1]));
				out.write(Integer.toString(getSlotSize(nb)));
				out.write("\n");
				break;
			case 112:
				out.write((isSelected()?"1":"0"));
				out.write("\n");
				break;
			default:
				System.out.println("COMMANDE INCONNUE : "+command);
				break;
			}
			out.flush();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		
	}
}
/* END TEMPLATE */
