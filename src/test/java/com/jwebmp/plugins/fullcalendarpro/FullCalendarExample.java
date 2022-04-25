package com.jwebmp.plugins.fullcalendarpro;

import com.guicedee.guicedinjection.*;
import com.guicedee.guicedservlets.undertow.*;
import com.guicedee.logger.*;
import com.jwebmp.core.base.angular.services.annotations.*;
import com.jwebmp.core.base.angular.services.compiler.*;
import com.jwebmp.core.base.angular.services.interfaces.*;
import com.jwebmp.core.base.html.*;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.logging.*;

import static com.jwebmp.core.base.angular.services.interfaces.ITSComponent.*;

@NgComponent(value = "full-calendar-example")
public class FullCalendarExample extends DivSimple<FullCalendarExample>
		implements INgComponent<FullCalendarExample>
{
	@Override
	public void init()
	{
		add(new FullCalendarProComponentExample());
		super.init();
	}
	
	public static void main(String[] args) throws Exception
	{
		LogFactory.configureDefaultLogHiding();
		LogFactory.configureConsoleColourOutput(Level.FINE);
		GuicedUndertow.boot("localhost", 6524);
	}
	
	@Test
	public void testAppSearch() throws IOException
	{
		GuiceContext.inject();
		for (INgApp<?> app : JWebMPTypeScriptCompiler.getAllApps())
		{
			JWebMPTypeScriptCompiler compiler = new JWebMPTypeScriptCompiler(app);
			
			System.out.println("Generating @NgApp (" + getTsFilename(app.getClass()) + ") " +
			                   "in folder " + getClassDirectory(app.getClass()));
			System.out.println("================");
			//	compiler.renderAppTS(app);
			System.out.println("================");
		}
	}
}