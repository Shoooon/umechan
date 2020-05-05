package ctrl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class SodanList {

	private String filename = "./src/ctrl/negativelist.csv";
	protected HashMap<String,String> sodanMap = new HashMap<String,String> ();

	public SodanList() {
		FileInputStream fi;
		try {
			// CSVファイルの読み込み
			fi = new FileInputStream(filename);
			InputStreamReader is = new InputStreamReader(fi);
			BufferedReader br = new BufferedReader(is);

			String line;
			// リストに格納
			while ((line = br.readLine()) != null) {
				sodanMap.put(line.split(",")[0], line.split(",")[1]);
			}

			// CSVファイルクローズ
			br.close();

		} catch (Exception e) {
			// エラーダイアログを生成＆設定
        	Alert dialog = new Alert(AlertType.ERROR);
        	dialog.setHeaderText(null);
        	dialog.setTitle("定義ファイル読み込みエラー");
        	dialog.setContentText("エラーが発生したよねぇ!? 原因と対策は!?");

        	// ダイアログを表示
        	dialog.showAndWait();

        	e.printStackTrace();
		}


	}

	public HashMap<String, String> getSodanMap() {
		return sodanMap;
	}

	public void setSodanMap(HashMap<String, String> sodanMap) {
		this.sodanMap = sodanMap;
	}



}
