package ctrl;

import java.util.HashMap;

public class UmeAnswer extends Controller{

	public String answer(String sodan) {

		String umeLebel = super.getCbLevel().getValue();

		String result = null;
		// 定義ファイルをロード
		SodanList sdLst = new SodanList();

		if(isEmpty(sodan)) {
			result = "相談内容を入力してないよねぇ！？";
			return result;
		}

		HashMap<String,String> ansMap = sdLst.getSodanMap();
		int matchflg = 0;
		for(String key : ansMap.keySet()) {
			if(sodan.contains(key)) {
				if(matchflg == 0) {
					result = ansMap.get(key);
					matchflg++;
				}
			}
		}

		if (matchflg > 1) {
			result = "相談が多すぎるよねぇ！？普通一つに絞るよねぇ！？";
		}
		if (isEmpty(result)) {
			result = "キミそんなに悩んでないよねぇ！？";
		}


		return result;
	}



	public boolean isEmpty(String value) {
		return ((value == null) || (value == ""));
	}
}
