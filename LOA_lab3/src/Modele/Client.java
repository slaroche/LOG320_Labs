package Modele;
import java.io.*;
import java.net.*;


class Client {
	public static void main(String[] args) {

		Socket MyClient;
		BufferedInputStream input;
		BufferedOutputStream output;
		LOAGameLogic gl = null;
		int[][] board = new int[8][8];
		
		try {
			MyClient = new Socket("localhost", 8888);
			input    = new BufferedInputStream(MyClient.getInputStream());
			output   = new BufferedOutputStream(MyClient.getOutputStream());
			BufferedReader console = new BufferedReader(new InputStreamReader(System.in));  
			while(true){
				char cmd = 0;

				cmd = (char)input.read();

				// D�but de la partie en joueur blanc
				if(cmd == '1'){
					byte[] aBuffer = new byte[1024];

					int size = input.available();
					////system.out.println("size " + size);
					input.read(aBuffer,0,size);
					String s = new String(aBuffer).trim();
					//system.out.println(s);
					String[] boardValues;
					boardValues = s.split(" ");
					int x=0,y=0;
					for(int i=0; i<boardValues.length;i++){
						board[x][y] = Integer.parseInt(boardValues[i]);
						x++;
						if(x == 8){
							x = 0;
							y++;
						}
					}
					gl = new LOAGameLogic(1);

					//system.out.println("Nouvelle partie! Vous jouer blanc, entrez votre premier coup : ");
					String move = null;
					move = gl.move(null);
					//system.out.println(move);
					output.write(move.getBytes(),0,move.length());
					output.flush();
				}
				// D�but de la partie en joueur Noir
				if(cmd == '2'){
					//system.out.println("Nouvelle partie! Vous jouer noir, attendez le coup des blancs");
					byte[] aBuffer = new byte[1024];

					int size = input.available();
					////system.out.println("size " + size);
					input.read(aBuffer,0,size);
					String s = new String(aBuffer).trim();
					//system.out.println(s);
					String[] boardValues;
					boardValues = s.split(" ");
					int x=0,y=0;
					for(int i=0; i<boardValues.length;i++){
						board[x][y] = Integer.parseInt(boardValues[i]);
						x++;
						if(x == 8){
							x = 0;
							y++;
						}
					}
					gl = new LOAGameLogic(2);
				}


				// Le serveur demande le prochain coup
				// Le message contient aussi le dernier coup jou�.
				if(cmd == '3'){
					byte[] aBuffer = new byte[16];

					int size = input.available();
					////system.out.println("size " + size);
					input.read(aBuffer,0,size);

					String s = new String(aBuffer);
					//system.out.println("Dernier coup : "+ s);
					//system.out.println("Entrez votre coup : ");
					String move = null;
					move = gl.move(s);
					//move = gl.move(s);
					output.write(move.getBytes(),0,move.length());
					output.flush();

				}
				// Le dernier coup est invalide
				if(cmd == '4'){
					//system.out.println("Coup invalide, entrez un nouveau coup : ");
					String move = null;
					System.out.println("damn");
					move = gl.move(null);
					output.write(move.getBytes(),0,move.length());
					output.flush();

				}
			}
		}
		catch (IOException e) {
			//system.out.println(e);
		}
	}
}
