package bank;

public class Gold extends Level {
	@Override
	public void setTheLevel(Customer c) {
		if (c.checkBalance < 10000) {
			c.setLevel(new Silver());
		}
		if ((c.checkBalance >= 10000) && c.checkBalance < 20000) {
			c.setLevel(new Gold());
		}
		if (c.checkBalance > 20000) {
			c.setLevel(new Platinum());
		}
	}

}
