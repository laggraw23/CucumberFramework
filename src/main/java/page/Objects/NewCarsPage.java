package page.Objects;

import page.Base.BasePage;

public class NewCarsPage  extends BasePage {
	
	public KiaCarPage gotoKia() {

		click("kia_LINK");

		return new KiaCarPage();

	}

	public BMWCarPage gotoBMW() {

		click("bmw_LINK");

		return new BMWCarPage();

	}

	public ToyotaCarPage gotoToyota() {

		click("toyota_LINK");

		return new ToyotaCarPage();
	}

	public HondaCarPage gotoHonda() {

		click("honda_LINK");
		
		return new HondaCarPage();
	}

}
