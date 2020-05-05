package ctrl;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class Controller implements Initializable{

        /** パネル：メイン */
        @FXML
        private AnchorPane mainPane;

        /** ラベル：相談内容 */
        @FXML
        private Label lbSodanNaiyo;

        /** テキストフィールド：相談内容 */
        @FXML
        private TextArea txtAreaSodanNaiyo;

        /** ラベル：ウメモトレベル */
        @FXML
        private Label lbLevel;

        /** コンボボックス：ウメモトレベル */
        @FXML
        private ChoiceBox<String> cbLevel;

        /** ボタン：相談 */
        @FXML
        private Button btnSodan;

        /*
         * (非 Javadoc)
         * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
         */
        @Override
        public void initialize(URL location, ResourceBundle resources) {

        	// コンボボックスに項目を追加
        	cbLevel.getItems().add("低");
        	cbLevel.getItems().add("中");
        	cbLevel.getItems().add("高");

        	// 初期選択状態を設定
        	cbLevel.getSelectionModel().select(0);

        }

        @FXML
        protected void onClickSodan(ActionEvent evt) {

        	// 相談内容を取得
        	String naiyo = getTxtAreaSodanNaiyo().getText();

        	// 回答生成クラスを呼び出す。
        	UmeAnswer ans = new UmeAnswer();
        	String answer = ans.answer(naiyo);

        	// ダイアログを生成＆設定
        	Alert dialog = new Alert(AlertType.INFORMATION);
        	dialog.setHeaderText("ウメモトレベル："+ getCbLevel().getValue());
        	dialog.setTitle("ウメモトアンサー");
        	dialog.setContentText(naiyo+ System.lineSeparator() +"→" + answer);

        	// ダイアログを表示
        	dialog.showAndWait();
        }

        /**
         * @return mainPane
         */
        public AnchorPane getMainPane() {
                return mainPane;
        }

        /**
         * @param mainPane セットする mainPane
         */
        public void setMainPane(AnchorPane mainPane) {
                this.mainPane = mainPane;
        }

		public Label getLbSodanNaiyo() {
			return lbSodanNaiyo;
		}

		public void setLbSodanNaiyo(Label lbSodanNaiyo) {
			this.lbSodanNaiyo = lbSodanNaiyo;
		}

		public TextArea getTxtAreaSodanNaiyo() {
			return txtAreaSodanNaiyo;
		}

		public void setTxtAreaSodanNaiyo(TextArea txtAreaSodanNaiyo) {
			this.txtAreaSodanNaiyo = txtAreaSodanNaiyo;
		}

		public Label getLbLevel() {
			return lbLevel;
		}

		public void setLbLevel(Label lbLevel) {
			this.lbLevel = lbLevel;
		}

		public ChoiceBox<String> getCbLevel() {
			return cbLevel;
		}

		public void setCbLevel(ChoiceBox<String> cbLevel) {
			this.cbLevel = cbLevel;
		}

		public Button getBtnSodan() {
			return btnSodan;
		}

		public void setBtnSodan(Button btnSodan) {
			this.btnSodan = btnSodan;
		}

}