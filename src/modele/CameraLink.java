package src.modele;

public class CameraLink {
	private int xPos,yPos;

	public CameraLink(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	public void BougerCamera(int xN , int yN) {
		this.xPos+=xN;
		this.yPos+=yN;
	}
	

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	
}
