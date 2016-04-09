package org.apache.nutch.analysis.unl.ta;

import java.util.Set;
import java.util.HashSet;
import java.util.Hashtable;


// doubt change this to intetface
public class Constant
{

	/*
	 PRONOUN
	 OBLIQUE_PRONOUN
	 PAST_TM_HUMAN
	 CLITIC_1
	 CLITIC_2
	 CLITIC_3
	 CLITIC_3a AlthAn
	 CLITIC_4
	 CLITIC_5
	 CLITIC_6
	 CLITIC_7
	 CLITIC_8
	 CLITIC_9
`	 DOUBLING_LETTER
	 AUX_VERB
	 */
	static byte[] cenRu = {16,7,31,30,5};		//UnicodeConverter.convert("சென்று");
	static byte[] vAzk = {27,2,28,14};		//UnicodeConverter.convert("வாழ்க்");
    static byte[] mALi = {23,2,29,3};			//UnicodeConverter.convert("மாளி");
	// postposition
	static byte[] anpadi = {1,31,22,1,18,3};	//UnicodeConverter.convert("அன்படி");
	static byte[] inpadi = {3,31,22,1,18,3};	//UnicodeConverter.convert("இன்படி");
    static byte[]AthathAl= {2,20,1,20,2,26};		//UnicodeConverter.convert("ஆததால்");
    static byte[]athAl={1,20,2,26};			// UnicodeConverter.convert("அதால்");
    static byte[]mARu={23,2,30,5}; 			//UnicodeConverter.convert("மாறு");
	// prefix
	static byte[] mm = {23,23};			//UnicodeConverter.convert("ம்ம்");
	static byte[] n_n_ = {21,21};			//UnicodeConverter.convert("ந்ந்");
	static byte[] vv = {27,27};			//UnicodeConverter.convert("வ்வ்");

	static byte Alum[] = {2,26,5,23};		//UnicodeConverter.convert("ஆலும்");

	// tense
	static byte sen[] = {16,7,31};			//UnicodeConverter.convert("சென்");
	static byte iin[] = {4,31};			//UnicodeConverter.convert("ஈன்");
	static byte men[] = {23,7,31};			//UnicodeConverter.convert("மென்");
	static byte ven[] = {27,7,31};			//UnicodeConverter.convert("வென்");

	// png
	static byte Athathu[] ={2,20,1,20,5};		//UnicodeConverter.convert("ஆதது");
	static byte Athavar[] ={2,20,1,27,1,25}; 	//UnicodeConverter.convert("ஆதவர்");

	// aux
	static byte paNNu[] = {22,1,19,19,5};		//UnicodeConverter.convert("பண்ணு");
	static byte iy[] = {3,24};			//UnicodeConverter.convert("இய்");

	// Misc
	static byte koNdiru[] = { 14, 10, 19, 18, 3, 25, 5}; //கொண்டிரு
	static byte iRRu[] = { 3, 30, 30, 5}; //இற்று

	static byte ththAn[] = { 20, 20, 2, 31};    //த்தான்
	static byte n_thAn[] = { 21, 20, 2, 31};  // ந்தான்
	static byte kayil[] = { 14, 9, 24, 3, 26};  // கையில்
	static byte kaiyil[] = { 14, 9, 24, 3, 26};  // கையில்
	static byte[] poothu = {22,11,20,5};		//UnicodeConverter.convert("போது");
	static byte[] eyya={3,24,1};

	// sandhi
	static byte ARR[] = { 2, 30, 30};  //ஆற்ற்
	static byte athth[] = { 1, 20, 20}; // அத்த்

	static byte Anavai[] = { 2, 31, 1, 27, 9}; //ஆனவை
   	// Adv Particle
	static byte appa[] = { 1, 22, 22, 1};  //அப்ப

	// PNG
	static byte van[] = { 27, 1, 31};      //வன்
	static byte vaL[] = { 27, 1, 29};   //வள்
	static byte varkaL[] = { 27, 1, 25, 14, 1, 29}; //வர்கள்
	static byte vaikaL[] = { 27, 9, 14, 1, 29}; //வைகள்
	static byte aL[] = { 1, 29};                        // அள்
	static byte arkaL[] = { 1, 25, 14, 1, 29}; //அர்கள்
	static byte aikaL[] = { 9, 14, 1, 29};   //  ஐகள்

	// POSTPOSITION
	static byte aRk[] = { 1, 30, 14};	//அற்க்
	static byte patum[]= {22,1,18,5,23};	//படும்
    static byte AlthAn[]= {2,26,20,2,31};	//ஆல்தான்
	static byte vaiththu[] ={27,9,20,20,5};		// UnicodeConverter.convert("வைத்து");
	static byte udaiya[] = {5,18,9,24,1};		//UnicodeConverter.convert("உடைய");
	static byte koNdu[] = {14,10,19,18,5};		//UnicodeConverter.convert("கொண்டு");
	static byte ethirE[] = {7,20,3,25,8};		//UnicodeConverter.convert("எதிரே");
	static byte bathilAka[] ={22,1,20,3,26,2,14,1}; //UnicodeConverter.convert("பதிலாக");
	static byte padi[] = {22,1,18,3};		//UnicodeConverter.convert("படி");
	static byte paRRiya[] = {22,1,30,30,3,24,1};	//UnicodeConverter.convert("பற்றிய");
	static byte mUlamAka[] ={23,6,26,1,23,2,14,1}; 	//UnicodeConverter.convert("மூலமாக");
	static byte varaikkum[] = {27,1,25,9,14,14,5,23};//UnicodeConverter.convert("வரைக்கும்");
	static byte irun_thu[] ={3,25,5,21,20,5}; 	//UnicodeConverter.convert("இருந்து");
	static byte aLavukku[] = {1,29,1,27,5,14,14,5};	//UnicodeConverter.convert("அளவுக்கு");
	static byte avarai[] ={1,27,1,25,9}; 		//UnicodeConverter.convert("அவரை");
	static byte pothilum[] = {22,11,20,3,26,5,23};	//UnicodeConverter.convert("போதிலும்");
	static byte maan[] = {23,2,31};			//UnicodeConverter.convert("மான்");
    static byte pattavai[]={22,1,18,18,1,27,9}; //பட்டவை
    static byte thakka[] ={ 20, 1, 14, 14, 1};//தக்க
    static byte[] uvarathth = {14,5,27,1,25,1,20,20};//"குவரத்த"
	static byte thakkathu[] ={ 20, 1, 14, 14, 1, 20, 5};//தக்கது
	static byte n_InggalAka[] = { 21, 4, 15, 14, 1, 29, 2, 14, 1};   // நீங்களாக
	static byte kAttilum[] = { 14, 2, 18, 18, 3, 26, 5, 23};   // காட்டிலும்
	static byte ERpa[] = { 8, 30, 22, 1};   // ஏற்ப
	static byte pathth[]={22,1,20,20};//பத்த்
	static byte n_ikar[] = { 21, 3, 14, 1, 25};      // நிகர்
	static byte n_igarAka[] = { 21, 3, 14, 1, 25, 2, 14, 1}; // நிகராக
	static byte mERpatta[] = { 23, 8, 30, 22, 1, 18, 18, 1};  // மேற்பட்ட
	static byte viLaivAka[] = { 27, 3, 29, 9, 27, 2, 14, 1};   // விளைவாக
	static byte pEril[] = { 22, 8, 25, 3, 26};  // பேரில்
	static byte pOl[] = { 22, 11, 26}; // போல்
	static byte allAtha[] = { 1, 26, 26, 2, 20, 1}; // அல்லாத
	static byte sArbAka[] = { 16, 2, 25, 22, 2, 14, 1}; // சார்பாக
	static byte sArbil[] = { 16, 2, 25, 22, 3, 26}; // சார்பில்
	static byte pAl[] = { 22, 2, 26}; // பால்
	static byte adiyil[] = { 1, 18, 3, 24, 3, 26}; // அடியில்
	static byte idaiyil[] = { 3, 18, 9, 24, 3, 26}; //இடையில்
	static byte idaiyE[] = { 3, 18, 9, 24, 8};  // இடையே
	static byte utpuRaththil[] = { 5, 18, 22, 5, 30, 1, 20, 20, 3, 26};  // உட்புறத்தில்
	static byte utpuRam[] = { 5, 18, 22, 5, 30, 1, 23}; // உட்புறம்
	static byte uLLAga[] = { 5, 29, 29, 2, 14, 1}; // உள்ளாக
	static byte kIzE[] = { 14, 4, 28, 8}; // கீழே
	static byte n_aduvil[] = { 21, 1, 18, 5, 27, 3, 26};  // நடுவில்
	static byte munnE[] = { 23, 5, 31, 31, 8}; // முன்னே
	static byte munnar[] = { 23, 5, 31, 31, 1, 25};  //முன்னர்
	static byte uLLitta[] = { 5, 29, 29, 3, 18, 18, 1}; // உள்ளிட்ட
	static byte appuRam[] = { 1, 22, 22, 5, 30, 1, 23}; // அப்புறம்
    static byte EyAnAl[] = {8,24,2,31,2,26};//ஏயானால்
	static byte kAttil[] = { 14, 2, 18, 18, 3, 26}; // காட்டில்
    static byte Itupattu[] = {4,18,5, 22, 1, 18, 18, 5};//ஈடுபட்டு
	// RP
	static byte Atha[] = { 2, 20, 1};   //ஆத
    //misc
    static byte ERpata[] = { 8, 30, 22, 1,18, 1};//ஏற்பட
	// init
	static byte vel[] = { 27, 7, 26};  // வெல்

	// IPM
	static byte aru[] = { 1, 25, 5};   // அரு
	static byte vAr[] = { 27, 2, 25}; // வார்
	static byte thAr[] = { 20, 2, 25}; // தார்

	// Aux Verb
	// VP/Inf
	static byte nEr[] = { 21, 8, 25}; // நேர்
	static byte piti[] = { 22, 3, 18, 3}; // பிடி
	static byte peRu[] = { 22, 7, 30, 5};//பெறு
	static byte pEsu[] = { 22, 8, 16, 5};//பேசு

	// VP
	static byte ati[] = { 1, 18, 3};//அடி
	static byte aruL[] = { 1, 25, 5, 29};//அருள்
	static byte Akku[] = { 2, 14, 14, 5};//ஆக்கு
	static byte Aku[] = { 2, 14, 5};//ஆகு
	static byte itu[] = { 3, 18, 5};//இடு
	static byte etu[] = { 7, 18, 5};//எடு
	static byte ezu[] = { 7, 28, 5};//எழு
	static byte eri[] = { 7, 25, 3};//எரி***
	static byte ozi[] = { 10, 28, 3};//ஒழி
	static byte Ongku[] = { 11, 15, 14, 5};//ஓங்கு
	static byte kAnpi[] = { 14, 2, 19, 22, 3};//காண்பி
	static byte kuvi[] = { 14, 5, 27, 3};//குவி
	static byte kUtu[] = { 14, 6, 18, 5};// Ã´***
	static byte sey[] = { 16, 7, 24};//செய்
	static byte thA[] = { 20, 2}; //தா
	static byte thara[] = { 20,1,25,1}; //îó 
	static byte thiri[] = { 20, 3, 25, 3}; // திரு
	static byte n_il[] = { 21, 3, 26};//நில்

	// INFINITIVE Suffix
	static byte lAm[] = { 26, 2, 23}; // லாம்
	static byte ttum[] = { 18, 18, 5, 23};//ட்டும்
	static byte vittAl[] = { 27, 3, 18, 18, 2, 26}; // விட்டால்
	static byte Amalum[] = { 2, 23, 1, 26, 5, 23};// ஆமலும்
	static byte AvittAlum[] = { 2, 27, 3, 18, 18, 2, 26, 5, 23};//ஆவிட்டாலும்
	static byte ena[] = { 7, 31, 1};// என
	static byte enRu[] = { 7, 31, 30, 5}; //என்று
	static byte AnAl[] = { 2, 31, 2, 26};//ஆனால்
	static byte vENtumAnAl[] = { 27, 8, 19, 18, 5, 23, 2, 31, 2, 26};// வேண்டுமானால்
	static byte vENtumena[] = { 27, 8, 19, 18, 5, 23, 7, 31, 1};// வேண்டுமென
	static byte vENtumenRu[] = { 27, 8, 19, 18, 5, 23, 7, 31, 30, 5};// வேண்டுமென்று
	static byte pata[] = { 22, 1, 18, 1}; // பட
	static byte vENtAm[] = { 27, 8, 19, 18, 2, 23};//வேண்டாம்
	static byte mutiyAthu[] = { 23, 5, 18, 3, 24, 2, 20, 5};//முடியாது
	static byte vitAthu[] = { 27, 3, 18, 2, 20, 5};//விடாது
	static byte Avitil[] = { 2, 27, 3, 18, 3, 26};//ஆவிடில்
	static byte AthE[] = { 2, 20, 8};  //ஆதே
	static byte patt[] = { 22, 1, 18, 18};//பட்ட்
	static byte pattu[] = { 22, 1, 18, 18, 5}; //பட்டு
	static byte pat[] = { 22, 1, 18}; ///பட்

	// VP
	static byte viR[] = { 27, 3, 30}; //விர்

	// TENSE
	static byte kiR[] = { 14, 3, 30}; //கிற்
	static byte kiRu[] = { 14, 3, 30, 5};//கிறு
	static byte kkiRu[] = { 14, 14, 3, 30, 5}; //க்கிறு
	static byte kinR[] = { 14, 3, 31, 30}; //கின்ற்
	static byte kinRu[] = { 14, 3, 31, 30, 5}; //கின்று
	static byte kkinRu[] = { 14, 14, 3, 31, 30, 5}; //க்கின்று
	static byte kkiR[] = { 14, 14, 3, 30};//க்கிற்
	static byte kkinR[] = { 14, 14, 3, 31, 30};//க்கின்ற்

	static byte n_th[] = { 21, 20};// ந்ற்
	static byte thth[] = { 20, 20};// த்த்
	static byte th[] = { 20};//த்
	static byte ath[] = { 1, 20};//அத்

	static byte viRk[] = { 27, 3, 30, 14};//விற்க்
	static byte n_iRk[] = { 21, 3, 30, 14}; //நிற்க்

	// Sandhi
	static byte AN[] = { 2, 19}; // ஆண்
	static byte thin[] = { 20, 3, 31}; //தின்
	static byte uN[] = { 5, 19}; //உண்
	static byte pUN[] = { 22, 6, 19};//பூண்

	static byte p[] = { 22};//ப்
	static byte v[] = { 27}; //வ்
	static byte vu[] = { 27, 5}; //வு
	static byte ththu[] = { 20, 20, 5};//த்து
	static byte n_thu[] = { 21, 20, 5};//ந்து
	static byte thu[] = { 20, 5};//து
	static byte n_[] = { 21};//ந்
	static byte tt[] = { 18, 18}; //ட்ட்
	static byte tu[] = { 18, 5};//டு
	static byte n[] = { 31};//ன்
	static byte pp[] = { 22, 22};//ப்ப்
	static byte in[] = { 3, 31};// இன்
	static byte an[] = { 1, 31};//அன்
	static byte RR[] = { 30, 30};//ற்ற்
	static byte Ru[] = { 30, 5};//று
	static byte RRu[] = { 30, 30, 5};//ற்று
	static byte Rk[] = { 30, 14}; //ற்க்
	static byte R[] = { 30}; //ற்
	static byte nn[] = { 31, 31}; //ன்ன்
	static byte m[] = { 23};// ம்

	static byte ng[] = { 15};//ங்
	static byte nj[] = { 38};//***
	static byte z[] = { 28};//ழ்
	static byte Otu[] = { 11, 18, 5};//ஓடு
	static byte AL[] = { 2, 29};//ஆள்
	static byte An[] = { 2, 31};//ஆன்
	static byte Ar[] = { 2, 25};//ஆர்
	static byte adA[] = { 1, 18, 2};//அடா
	static byte adi[] = { 1, 18, 3};//அடி
	static byte E[] = { 8};//ஏ
	static byte Am[] = { 2,23};//ஆம்
	static byte ellaam[] ={7,26,26,2,23}; 		//UnicodeConverter.convert("எல்லாம்");

	static byte kaL[] = { 14, 1, 29};//கள்
	static byte thAn[] = { 20, 2, 31};//தான்
	static byte avan[] = { 1, 27, 1, 31};//அவன்
	static byte avaL[] = { 1, 27, 1, 29};//அவள்
	static byte avar[] = { 1, 27, 1, 25};//அவர்
	static byte avai[] = { 1, 27, 9};//அவை

	static byte avaikaL[] = { 1, 27, 9, 14, 1, 29};//அவைகள்
	static byte n_I[] = { 21, 4};//நீ
	static byte n_IngkaL[] = { 21, 4, 15, 14, 1, 29};//நீங்கள்
	static byte n_Ir[] = { 21, 4, 25};//நீர்
	static byte n_IvIr[] = { 21, 4, 27, 4, 25};//நீவீர்
	static byte n_An[] = { 21, 2, 31};//நான்
	static byte n_Am[] = { 21, 2, 23};//நாம்
	static byte n_AngkaL[] = { 21, 2, 15, 14, 1, 29};//நாங்கள்
	static byte thAngkaL[] = { 20, 2, 15, 14, 1, 29};//தாங்கள்
	static byte thAm[] = { 20, 2, 23};//தாம்

	static byte ithu[] = { 3, 20, 5};//இது
	static byte ivaikaL[] = { 3, 27, 9, 14, 1, 29};//இவைகள்
	static byte ivai[] = { 3, 27, 9};//இவை
	static byte em[] = { 7, 23};//எம்
	static byte engkaL[] = { 7, 15, 14, 1, 29};//எங்கள்

	static byte um[] = { 5, 23};//உம்
	static byte iru[] = { 3, 25, 5};//இரு
	static byte ar[] = { 1, 25};//அர்
	static byte En[] = { 8, 31};//ஏன்
	static byte Om[] = { 11, 23};//ஓம்
	static byte ana[] = { 1, 31, 1};//அன
	static byte anar[] = { 1, 31, 1, 25};//அனர்
	static byte Ana[] = { 2, 31, 1};//ஆன
	static byte Aka[] = { 2, 14, 1};//ஆக
	static byte athu[] = { 1, 20, 5};//அது
	static byte Ay[] = { 2, 24};//ஆய்
	static byte ArkaL[] = { 2, 25, 14, 1, 29};//ஆர்கள்
	static byte mArkaL[] = { 23, 2, 25, 14, 1, 29};//மார்கள்
	static byte mAr[] = { 23, 2, 25};//மார்
	static byte IrkaL[] = { 4, 25, 14, 1, 29};//ஈர்கள்
	static byte Ir[] = { 4, 25};//ஈர்
	static byte Or[] = { 11, 25};//ஓர்
	static byte Al[] = { 2, 26};//ஆல்
	static byte a[] = {1};//அ
	static byte au[] = { 12};//ஒள
	static byte A[] = { 2};//ஆ
	static byte O[] = { 11};//ஓ
	static byte ka[] = { 14, 1};//க
	static byte i[] = { 3};//இ
	static byte u[] = { 5};//உ
	static byte thal[] = { 20, 1, 26};//தல்
	static byte t[] = { 18};//ட்
	static byte koNt[] = { 14, 10, 19, 18};//கொண்ட்
	static byte koNtu[] = { 14, 10, 19, 18, 5};//கொண்டு
	static byte vitu[] = { 27, 3, 18, 5};//விடு
	static byte Avitu[] = { 2,27, 3, 18, 5};//ஆவிடு
	static byte kUda[] = { 14, 6, 18, 1};//கூட
	static byte ai[] = { 9};//ஐ
	static byte pOyiRRu[] = { 22, 11, 24, 3, 30, 30, 5};//போயிற்று
	static byte AyiRRu[] = { 2, 24, 3, 30, 30, 5};//ஆயிற்று
	static byte thIr[] = { 20, 4, 25};//தீர்
	static byte kattu[] = { 14, 1, 18, 18, 5};//கட்டு
	static byte L[] = { 29};//ள்
	static byte uLL[] = { 5,29, 29};//உள்ள்
	static byte k[] = { 14};//க்
	static byte tk[] = { 18, 14};//ட்க்
	static byte l[] = { 26};//ல்
	static byte ll[] = { 26, 26};//ல்ல்
	static byte y[] = { 24};//ய்
	static byte Amal[] = { 2, 23, 1, 26};//ஆமல்
   	static byte va[] = { 27, 1};//வ
	static byte N[] = { 19};//ண்
	static byte kaN[] = { 14, 1, 19};//கண்
	static byte kAN[] = { 14, 2, 19};//காண்
	static byte koN[] = { 14, 10, 19};//கொண்

	static byte kaR[] = { 14, 1, 30};//கற்
	static byte kaRk[] = { 14, 1, 30, 14};//கற்க்
	static byte tha[] = { 20, 1};//த
	static byte kEL[] = { 14, 8, 29};//கேள்
	static byte kEt[] = { 14, 8, 18};//கேட்
	static byte kEtk[] = { 14, 8, 18, 14};//கேட்க்
	static byte kal[] = { 14, 1, 26};//கல்

	static byte vi[] = { 27, 3};//வி
	static byte se[] = { 16, 7};//செ
	static byte sA[] = { 16, 2};//சா
	static byte yy[] = { 24, 24};//ய்ய்
	static byte kk[] = { 14, 14};//க்க்
	static byte r[] = { 25};//ர்
	static byte vENdum[] = { 27, 8, 19, 18, 5, 23};//வேண்டும்
	static byte veNtAm[] = { 27, 8, 19, 18, 2, 23};//வேண்டாம்
	static byte kUdum[] = { 14, 6, 18, 5, 23};//கூடும்
	static byte kUtAthu[] = { 14, 6, 18, 2, 20, 5};//கூடாது
	static byte illai[] = { 3, 26, 26, 9};//இல்லை
	static byte alla[] = { 1, 26, 26, 1};//அல்ல
	static byte kka[] = { 14, 14, 1};//க்க
	static byte patu[] = { 22, 1, 18, 5};//படு
	static byte koL[] = { 14, 10, 29};//கொள்
	static byte avarkaL[] = { 1, 27, 1, 25, 14, 1, 29};//அவர்கள்
	static byte kAttu[] = { 14, 2, 18, 18, 5};//காட்டு
	static byte tholai[] = { 20, 10, 26, 9};//தொலை
	static byte azu[] = { 1, 28, 5};//அழு
	static byte kotu[] = { 14, 10, 18, 5};//கொடு
	static byte kita[] = { 14, 3, 18, 1};//கிட
	static byte kizi[] = { 14, 3, 28, 3};//கிழி
	static byte thaLLu[] = { 20, 1, 29, 29, 5};//தள்ளு
	static byte pOtu[] = { 22, 11, 18, 5};//போடு
	static byte pO[] = { 22, 11};//போ
	static byte pOk[] = { 22, 11, 14};//போக்
	static byte sAk[] = { 16, 2, 14};//சாக்
	static byte vA[] = { 27, 2};//வா
	static byte cey[] = { 16, 7, 24};//செய்
	static byte vai[] = { 27, 9};//வை
	static byte mudi[] = { 23, 5, 18, 3};//முடி
	static byte pAr[] = { 22, 2, 25};//பார்
	static byte zh[] = { 28};//ழ்
	static byte Athey[] = { 2, 20, 8};//ஆதே
	static byte AthIrkaL[] = { 2, 20, 4, 25, 14, 1, 29};//ஆதீர்கள்
	static byte Athu[] = { 2, 20, 5};//ஆது
	static byte AvittAl[] = { 2, 27, 3, 18, 18, 2, 26};//ஆவிட்டால்
	static byte var[] = { 27, 1, 25};//வர்
	static byte thar[] = { 20, 1, 25};//தர்
	static byte nRu[] = { 31, 30, 5};//ன்று
	static byte Ntu[] = { 19, 18, 5};//ண்டு
	static byte NN[] = { 19, 19};//ண்ண்
	static byte nR[] = { 31, 30};//ன்ற்
	static byte ttu[] = { 18, 18, 5};//ட்டு
	static byte varu[] = { 27, 1, 25, 5};//வரு
	static byte tharu[] = { 20, 1, 25, 5};//தரு
	static byte kAran[] = { 14, 2, 25, 1, 31};//காரன்
	static byte kAri[] = { 14, 2, 25, 3};//காரி
	static byte kAr[] = { 14, 2, 25};//கார்
	static byte ERk[] = { 8, 30, 14};//ஏற்க்

	// post positions
	static byte tho[] = { 20, 10};//தொ
	static byte[] mUlam = { 23, 6, 26, 1, 23};//மூலம்
	static byte[] illAmal = { 3, 26, 26, 2, 23, 1, 26};//இல்லாமல்
	static byte[] vasam = { 27, 1, 16, 1, 23};//வசம்
	static byte[] thORum = { 20, 11, 30, 5, 23};//தோறும்
	static byte[] maththiyil = { 23, 1, 20, 20, 3, 24, 3, 26};//மத்தியில்
	static byte[] pakkam = { 22, 1, 14, 14, 1, 23};//பக்கம்
	static byte[] mEl = { 23, 8, 26};//மேல்
	static byte[] kIz = { 14, 4, 28};//கீழ்
	static byte[] muthal = { 23, 5, 20, 1, 26};//முதல்
	static byte[] vaziyAka = { 27, 1, 28, 3, 24, 2, 14, 1};//வழியாக
	static byte[] pArththu = { 22, 2, 25, 20, 20, 5};//பார்த்து
	static byte[] n_Okki = { 21, 11, 14, 14, 3};//நோக்கி
	static byte[] suRRi = { 16, 5, 30, 30, 3};//சுற்றி
	static byte[] thANti = { 20, 2, 19, 18, 3};//தாண்டி
	static byte[] thavira = { 20, 1, 27, 3, 25, 1};//தவிர
	static byte[] Otti = { 11, 18, 18, 3};//ஓட்டி
	static byte[] appAl = { 1, 22, 22, 2, 26};//அப்பால்
	static byte[] appuram = { 1, 22, 22, 5, 30, 1, 23};//அப்புறம்
	static byte[] uL = { 5, 29};//உள்
	static byte[] uLLE = { 5, 29, 29, 8};//உள்ளே
	static byte[] pinnE = { 22, 3, 31, 31, 8};//பின்னே
	static byte[] veLiyE = { 27,12, 24,8};//வெளியே***
	static byte[] itaiyE = { 3, 18, 9, 24, 8};//இடையே
	static byte[] vittu = { 27, 3, 18, 18, 5};//விட்டு
	static byte[] pOla = { 22, 11, 26, 1};//போல
	static byte[] vita = { 27, 3, 18, 1};//விட
	static byte[] munnittu = { 23, 5, 31, 31, 3, 18, 18, 5};//முன்னிட்டு
	static byte[] poruththavarai = { 22, 10, 30, 5, 20, 20, 1, 27, 1, 25, 9};//பொறுத்தவரை
	static byte[] mAththiram = { 23, 2, 20, 20, 3, 25, 1, 23};//மாத்திரம்
	static byte[] n_aduvE = { 21, 1, 18, 5, 27, 8};//நடுவே
	static byte[] arukil = { 1, 25, 5, 14, 3, 26};//அருகில்
	static byte[] pathil = { 22, 1, 20, 3, 26};//பதில்
	static byte[] uriya = { 5, 25, 3, 24, 1};//உரிய
	static byte[] uriyathu = { 5, 25, 3, 24, 1,20,5};//உரியது
	static byte[] thakun_tha = { 20, 1, 14, 5, 21, 20, 1};//தகுந்த
	static byte[] mARAka = { 23, 2, 30, 2, 14, 1};//மாறாக
	static byte[] n_IrAka = { 21, 8, 25, 2, 14, 1};//நேராக
	static byte[] kuRukkE = { 14, 5, 30, 5, 14, 14, 8};//குறுக்கே
	static byte[] paRRi = { 22, 1, 30, 30, 3};//பற்றி
	static byte[] kuRiththu = { 14, 5, 30, 3, 20, 20, 5};//குறித்து
	static byte[] kuRiththa = { 14, 5, 30, 3, 20, 20, 1};//குறித்த
	static byte[] mAthiri = { 23, 2, 20, 3, 25, 3};//மாதிரி
	static byte[] otti = { 10, 18, 18, 3};//ஒட்டி
	static byte[] ottiya = { 10, 18, 18, 3, 24, 1};//ஒட்டிய
	static byte[] aNmaiyil = { 1, 19, 23, 9, 24, 3, 26};//அண்மையில்

	static byte[] thottu = { 20, 10, 18, 18, 5};//தொட்டு
	static byte[] mAtt = { 23, 2, 18, 18};//மாட்ட்
	static byte[] mAttu = { 23, 2, 18, 18, 5};//மாட்டு
	static byte[] mAttAn = { 23, 2, 18, 18, 2, 31};//மாட்டான்

	// clitic
	static byte[] ennum = { 7, 31, 31, 5, 23};//என்னும்
	static byte[] Akilum = { 2, 14, 3, 26, 5, 23};//ஆகிலும்
	static byte[] Ayinum = { 2, 24, 3, 31, 5, 23};//ஆயினும்
	static byte[] Avathu = { 2, 27, 1, 20, 5};//ஆவது
	static byte[] ammA = { 1, 23, 23, 2};//அம்மா
	static byte[] appA = { 1, 22, 22, 2};//அப்பா
	static byte[] ayyA = { 1, 24, 24, 2};//அய்யா

	// adverbial participles
	static byte[] pozuthu = { 22, 10, 28, 5, 20, 5};//பொழுது
	
	static byte[] pOthu = { 22, 11, 20, 5};//போது
	static byte[] mun = { 23, 5, 31};//முன்
	static byte[] munpu = { 23, 5, 31, 22, 5};//முன்பு
	static byte[] munnAl = { 23, 5, 31, 31, 2, 26};//முன்னால்
	static byte[] pin = { 22, 3, 31};//பின்
	static byte[] pinpu = { 22, 3, 31, 22, 5};//பின்பு
	static byte[] pinnAl = { 22, 3, 31, 31, 2, 26};//பின்னால்
	static byte[] piRaku = { 22, 3, 30, 1, 14, 5};//பிறகு
	static byte[] utanE = { 5, 18, 1, 31, 8};//உடனே
	static byte[] utan = { 5, 18, 1, 31};//உடன்
	static byte[] vaNNam = { 27, 1, 19, 19, 1, 23};//வண்ணம்
	static byte[] vARu = { 27, 2, 30, 5};//வாறு
	static byte[] pati = { 22, 1, 18, 3};//படி
	static byte[] mattum = { 23, 1, 18, 18, 5, 23};//மட்டும்
	static byte[] mattilum = { 23, 1, 18, 18, 3, 26, 5, 23};//மட்டிலும்
	static byte[] varai = { 27, 1, 25, 9};//வரை
	static byte[] varaiyil = { 27, 1, 25, 9, 24, 3, 26};//வரையில்
	static byte[] Ath = { 2, 20};//ஆத்

	// potential suffixes
	static byte[] alAm = { 1, 26, 2, 23};//அலாம்
	static byte[] kalAm = { 14, 1, 26, 2, 23};//கலாம்
	static byte[] kkalAm = { 14, 14, 1, 26, 2, 23};//க்கலாம்
	static byte[] makkaL = { 23, 1, 14, 14, 29};//மக்கள்***
	static byte[] makaL = { 23, 1, 14, 29};//மகள்***

	static byte[] ivar = { 3, 27, 1, 25};//இவர்
	static byte[] ina = { 3, 31, 1};//இன

	static byte il[] = { 3, 26};//இல்
	static byte itam[] = { 3, 18, 1, 23};//இடம்
	static byte ukku[] = { 5, 14, 14, 5};//உக்கு
	static byte ukk[] = { 5, 14, 14};//உக்க்
	static byte iRku[] = { 3, 30, 14, 5};//இற்கு
	static byte iRkAka[] = { 3, 30, 14, 2, 14, 1};//இற்காக
	static byte aRkAka[] = { 1, 30, 14, 2, 14, 1};//அற்காக
	static byte aRku[] = { 1, 30, 14, 5};//அற்கு
	static byte athaRku[] = { 1,20,1, 30, 14, 5};//அதற்கு
	static byte iRk[] = { 3, 30, 14};//இற்க்
	static byte kku[] = { 14, 14, 5};//க்கு
	static byte akku[] = { 1, 14, 14, 5};//அக்கு
	static byte akk[] = { 1, 14, 14};//அக்க்
	static byte kkaL[] = { 14, 14, 1, 29};//க்கள்

	static byte ilirun_thu[] = { 3, 26, 3, 25, 5, 21, 20, 5};//இலிருந்து
	static byte itamirun_thu[] = { 3, 18, 1, 23, 3, 25, 5, 21, 20, 5};//இடமிருந்து
	static byte ilirun_th[] = { 3, 26, 3, 25, 5, 21, 20};//இலிருந்த்
	static byte itamirun_th[] = { 3, 18, 1, 23, 3, 25, 5, 21, 20};//இடமிருந்த்
	static byte utaiya[] = { 5, 18, 9, 24, 1};//உடைய
	static byte aRRu[] = { 1, 30, 30, 5};//அற்று
	static byte aRRa[] = { 1, 30, 30, 1};//அற்ற
	static byte ev[] = { 7, 27};//எவ்
	static byte ku[] = { 14, 5};//கு
	static byte I[] = { 4};//ஈ
	static byte s[] = { 16};//ச்
	static byte ss[] = { 16, 16};//ச்ச்
	static byte U[] = { 6};//ஊ
	static byte utaiyathu[] = { 5, 18, 9, 24, 1, 20, 5};//உடையது

	static byte kE[] = { 14, 8};//கே
	static byte en[] = { 7, 31};//என்
	static byte un[] = { 5, 31};//உன்
	static byte ivan[] = { 3, 27, 1, 31};//இவன்
	static byte ivaL[] = { 3, 27, 1, 29};//இவள்
	static byte n_am[] = { 21, 1, 23};//நம்
	static byte yAn[] = { 24, 2, 31};//யான்
	static byte yAm[] = { 24, 2, 23};//யாம்
	static byte than[] = { 20, 1, 31};//தன்
	static byte tham[] = { 20, 1, 23};//தம்
	static byte ivarkaL[] = { 3, 27, 1, 25, 14, 1, 29};//இவர்கள்
	static byte e[] = { 7};//எ
	static byte o[] = { 10};//ஒ
	static byte vaRR[] = { 27, 1, 30, 30};//வற்ற்
	static byte aththu[] = { 1, 20, 20, 5};//அத்து
	static byte ellA[] = { 7, 26, 26, 2};//எல்லா
	static byte nAyanmArkaL[] = { 21, 2, 24, 1, 31, 23, 2, 25, 14, 1, 29};//நாயன்மார்கள்

	static byte sumArkaL[] = { 16, 5, 23, 2, 25, 14, 1, 29};//சுமார்கள்
	static byte iya[] = { 3, 24, 1};//இய
	static byte uLLa[] = { 5, 29, 29, 1};//உள்ள
	static byte angku[] = { 1, 15, 14, 5};//அங்கு
	static byte ingku[] = { 3, 15, 14, 5};//இங்கு
	static byte engku[] = { 7, 15, 14, 5};//எங்கு
	static byte umpadi[] = { 5, 23, 22, 1, 18, 3};//உம்படி
	static byte athan[] = { 1, 20, 1, 31};//அதன்
	static byte ithan[] = { 3, 20, 1, 31};//இதன்
	static byte ethan[] = { 7, 20, 1, 31};//எதன்

	// ISM
	static byte ta[] = { 18, 1};//ட
	static byte tA[] = { 18, 2};//டா
	static byte ti[] = { 18, 3};//டி
	static byte mmA[] = { 23, 23, 2};//ம்மா
	static byte ppA[] = { 22, 22, 2};//ப்பா
	static byte yyA[] = { 24, 24, 2};//ய்யா

	static byte utA[] = { 5, 18, 2};//உடா
	static byte uti[] = { 5, 18, 3};//உடி
	static byte ummA[] = { 5, 23, 23, 2};//உம்மா
	static byte uppA[] = { 5, 22, 22, 2};//உப்பா
	static byte uyyA[] = { 5, 24, 24, 2};//உய்யா



     static byte al[] = { 1, 26};//அல்

	// IPM
	static byte ngkaL[] = { 15, 14, 1, 29};//ங்கள்
	static byte ungkaL[] = { 5, 15, 14, 1, 29};//உங்கள்

	static byte irukkattum[] = { 3, 25, 5, 14, 14, 1, 18, 18, 5, 23};//இருக்கட்டும்
	static byte uNtu[] = { 5, 19, 18, 5};//உண்டு
	static byte uLLathu[] = { 5, 29, 29, 1, 20, 5};//உள்ளது
	static byte uLLana[] = { 5, 29, 29, 1, 31, 1};//உள்ளன
	static byte Anathu[] = { 2, 31, 1, 20, 5};//ஆனது
	static byte Akum[] = { 2, 14, 5, 23};//ஆகும்
	static byte AkiRathu[] = { 2, 14, 3, 30, 1, 20, 5};//ஆகிறது
	static byte AkAthu[] = { 2, 14, 2, 20, 5};//ஆகாது
	static byte iLLai[] = { 3, 26, 26, 9};//இல்லை
	static byte pathu[] ={22,1,20,5};//பது
	//postposition thAn

	    static byte kaiyilEthAn[]={14,9,24,3,26,8,20,2,31};//கையிலேதான்
	    static byte enRuthAn[]={7,31,30,5,20,2,31};//என்றுதான்
	    static byte pattavaithAn[]={22,1,18,18,1,20,2,31};//பட்டதான்
	    static byte athuthAn[] ={1,20,5,20,2,31};//அதுதான்
	    static byte EthAn[] ={8,20,2,31};//ஏதான்
	    static byte ukkuththAn[] ={5,14,14,5,20,20,2,31};//உக்குத்தான்
	    static byte kaLthAn[] ={14,1,29,20,2,31};//கள்தான்
	    static byte enpathuthAn[] ={7,31,22,1,20,5,20,2,31};//என்பதுதான்
	    static byte ilthAn[] ={3,26,20,2,31};//இல்தான்
	    static byte pOthuthAn[] ={22,11,20,5,20,2,31};//போதுதான்
	    static byte mIthuthAn[] ={23,4,20,5,20,2,31};//மீதுதான்
	    static byte mIthu[] ={23,4,20,5};	//மீது
	    static byte umthAn[] ={7,23,20,2,31};//எம்தான்
	    static byte patithAn[] ={22,1,18,3,20,2,31};//படிதான்
	    static byte uLthAn[] ={5,26,20,2,31};//உல்தான்
	    static byte maithAn[] ={23,9,20,2,31};//மைதான்
	    static byte ithAn[] ={9,20,2,31};//ஐதான்
	    static byte AkaththAn[] ={2,14,1,20,20,2,31};//ஆகத்தான்
	    static byte nthAn[] ={31,20,2,31};//ன்தான்
	    static byte AththAn[] ={2,20,20,2,31};//ஆத்தான்
	    static byte uthAn[] ={5,20,2,31};//உதான்
	    static byte athaiththAn[] ={1,20,9,20,20,2,31};//அதைத்தான்
	    static byte kaLiththAn[] ={14,1,29,9,20,20,2,31};//களைத்தான்***
	    static byte pOlthAn[] ={22,11,26,20,2,31};//போல்தான்
	    static byte vittuththAn[] ={27,3,18,18,5,20,20,2,31};//விட்டுத்தான்


	//adjust
	static byte[] kaivittu = { 14,9,27, 3, 18, 18, 5};//கைவிட்டு
	static byte[] pEravai = { 22,8,25, 1, 27, 9};//பேரவை

	static byte[][] PRONOUN = {
		avan, avaL, avai, avarkaL, avar, athu, avaikaL, ivan, ivaL, ivarkaL,
		ivar, ithu, ivaikaL, ivai
	};

	static byte[][] PRONOUN_CASE = {
		en, em, engkaL, n_am, tham, than, un, ungkaL, um, a, i
	};

	static byte[][] PRONOUN_CLITIC = {
		n_I, n_IngkaL, n_IvIr, n_Ir, n_An, n_Am, n_AngkaL, thAngkaL, thAn, thAm,
		yAm, yAn
	};

	static byte[][] PAST_TM_HUMAN = {
		in, i, n_th, thth, th, n, t, R
	};

	static byte[][] VP_SUFFIX = {
		u
	};

	static byte[][] CLITIC_1 = {
		A, O, E,
	};

	static byte[][] CLITIC_2 = {
		thAn,
	};

	static byte[][] CLITIC_3 = {
		mattum, mAththiram,
	};
    static byte[][] CLITIC_3a = {
				AlthAn
	};
	static byte[][] CLITIC_4 = {
		ennum, Akilum, Ayinum,
	};

	static byte[][] CLITIC_5 = {
		kUda,
	};

	static byte[][] CLITIC_6 = {
		um,
	};

	static byte[][] CLITIC_7 = {
		Avathu,
	};

	static byte[][] CLITIC_8 = {
		adA, adi, ammA, appA, ayyA,
	};

	static byte[][] CLITIC_9 = {
		E
	};
	//
static byte[][] CLITIC_11 = {
		Am
	};
	//
	//
	static byte[][] CLITIC_12 = {
			Ana
		};
	//
	static byte[][] DOUBLING_LETTER = {
		N, n, m, l, L, y
	};

	static byte[][] ADJECTIVE = {
		Ana, iya, uLLa, aRRa
	};

	static byte[][] AUX_VERB = {
		patu, n_il, tholai, thIr, thiri, thA, sey, koL, kotu, kUtu, kuvi, kita,
		kAnpi, kAttu, kattu, Ongku, ozi, eri, ezu, etu, vitu, aruL, ati, vai,Avitu,
		itu, vA, pOtu, pO, pEsu, peRu, piti, pAr, nEr, koNdiru, iru, Aku, Akku,pattu,
		mudi, thaLLu, sA, paNNu,uLL,pata,kizi
	};

	static byte[][] aie = { a, i, e};
	static byte[][] kctp = { kk, ss, thth, pp, mm, n_n_, vv};
	static byte[][] prefix = new byte[aie.length * kctp.length][];

	static
	{
		int c = 0;

		for (int i = 0; i < aie.length; i++)
		{
			for (int j = 0; j < kctp.length; j++)
			{
				////System.out.println("Inside ByTEMeth:"+ByteMeth.addArray(aie[i], kctp[j]));
				prefix[c] = ByteMeth.addArray(aie[i], kctp[j]);
				c++;
			}
		}
	}
    static byte[][] RTense = {
			kkinR, kkiR, kiR, kinR, in, n_th, thth, th, n, tt, nR, RR, iy, v, pp, p,sAk
	};
	static byte[][] Tense = {
		kkinR, kkiR, kiR, kinR, in, n_th, thth, th, n, t, nR, RR, iy, v, pp, p
	};

	static byte[][] PastTense = {
		in, n_th, thth, th, n, t, nR, RR, iy,
	};

	static byte[][] Infinity = {
		kka, ka, a
	};

	static byte[][] auxSuffixVP_y_i = {
		iy, // vp-i + Sandhi-y
		y, // vp-y
		in, // past
		i, n_th, thth, th, n, t, R
	};

	static byte[] KCTP = {
		k[0], s[0], th[0], p[0]
	};

	static byte[][] auxSuffixVP_u = new byte[PAST_TM_HUMAN.length * VP_SUFFIX.length + 2][];

	static
	{
		int c = 0;

		for (int i = 0; i < PAST_TM_HUMAN.length; i++)
		{
			for (int j = 0; j < VP_SUFFIX.length; j++)
			{
				auxSuffixVP_u[c] = ByteMeth.addArray(PAST_TM_HUMAN[i],
				  VP_SUFFIX[j]);
				c++;
			}
		}
		auxSuffixVP_u[c] = i;
		c++;
		auxSuffixVP_u[c] = y;
	}
}
