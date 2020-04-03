package NL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import DL.aerolinea;
import DL.aireportua;
import DL.hegaldia;
import PL.IOrokor;

public class HegaldiKudeaketa 
{
	/*
	 * Hegaldi merkeena aukeratzen duen metodoa. Erabiltzaileak helmuga aireportu bakarra ahalko du jarri, baina irteera aireportuak nahi bezainbeste ahalko ditu jarri, konparazio hobeago bat egin ahal izateko.
	 */
	
	public static ArrayList<hegaldia> merkeenak (ArrayList<aireportua> irteera, aireportua helmuga)
	{

		ArrayList<hegaldia> hegaldiak=new ArrayList<hegaldia>(); //Hegaldi guztiak izango dituen ArrayList-a.
		boolean irteerak=false;
		boolean b=false;
		int u=0;

		/*
		 * Nahi ditugun irteera eta helmugako aireportuak dituzten hegaldiak lortzeko metodoa
		 */
		
		for(int i=0;i<hegaldiak.size();i++)
		{
			if(b==true)
			{
				i=u;
			}
			b=false;
			if (hegaldiak.get(i).getHelmuga().getIzena().equals(helmuga.getIzena()))
			{
			}
			else
			{
				hegaldiak.remove(i);
				u=i;
				b=true;
			}
			if(i<=hegaldiak.size()-1)
			{
			for(int o=0;o<irteera.size();o++)
			{
				if(irteera.get(o).getIzena().equals(hegaldiak.get(i).getIrteera().getIzena()))
				{
					irteerak=true;
					
				}
				else
				{
					irteerak=false;
				}
			}
			if(irteerak==false)
			{
				hegaldiak.remove(i);
				u=i;
				b=true;
			}	
			if((b==true)&&(i==hegaldiak.size()-1))
			{
				i=i-1;
			}
			}
			
		}
		System.out.println("ordenauta");
		Collections.sort(hegaldiak);
		for(int i=0;i<hegaldiak.size();i++)
		{
			System.out.println("hg" + hegaldiak.get(i).getPrezioa());
		}
		return hegaldiak;
				
	}
}
