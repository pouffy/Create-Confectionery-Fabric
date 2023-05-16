package com.pouffydev.create_confectionery;

import com.google.common.base.Supplier;
import com.google.gson.JsonElement;
import com.simibubi.create.foundation.data.LangPartial;
import com.simibubi.create.foundation.utility.Lang;

public enum ConfectioneryLangPartials implements LangPartial {
	//ADVANCEMENTS("Advancements", AllAdvancements::provideLangEntries),
	INTERFACE("UI & Messages"),
	//SUBTITLES("Subtitles", AllSoundEvents::provideLangEntries),
	TOOLTIPS("Item Descriptions"),
	//PONDER("Ponder Content", PonderLocalization::provideLangEntries),
	EXTRAS("Stuff I Don't Think Is Automatically Generated")

	;

	private final String displayName;
	private final Supplier<JsonElement> provider;

	private ConfectioneryLangPartials(String displayName) {
		this.displayName = displayName;
		String fileName = Lang.asId(name());
		this.provider = () -> LangPartial.fromResource(Confectionery.ID, fileName);
	}

	private ConfectioneryLangPartials(String displayName, Supplier<JsonElement> provider) {
		this.displayName = displayName;
		this.provider = provider;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public JsonElement provide() {
		return provider.get();
	}
}
