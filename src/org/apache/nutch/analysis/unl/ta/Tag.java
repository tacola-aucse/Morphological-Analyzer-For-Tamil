package org.apache.nutch.analysis.unl.ta;


public interface Tag
{
	String ENGLISH_ABBREVIATED = "English_Abbreviated";
	String ENGLISH_EXPAND = "English_Expanded";
	String TAMIL_ABBREVIATED = "Tamil_Abbreviated";
	String TAMIL_EXPAND = "Tamil_Expanded";

	int Noun = 100;
	int Pronoun = 101;
	int PronounCase = 102;
	int PronounOblique = 103;
	int PronounClitic = 104;
	int InterrogativeNoun = 105;
	int AdjectivalNoun = 106;
	int NonTamilNoun = 107;
	int Verb = 200;
	int AuxiliaryVerb = 201;
	int FiniteVerb = 202;
	int NegativeFiniteVerb = 203;
	int Adjective = 300;
	int DemonstrativeAdjective = 301;
	int InterrogativeAdjective = 302;
	int Postposition = 303;
	int Conjunction = 304;
	int Particle = 305;
	int Intensifier = 306;
	int Interjection = 307;
	int Adverb = 400;
	int AccusativeCase = 500;
	int InstrumentalCase = 501;
	int DativeCase = 502;
	int AssociativeCase = 503;
	int LocativeCase = 504;
	int GenitiveCase = 506;
	int AdverbialSuffix = 600;
	int AdjectivalSuffix = 601;
	int PostpositionBound = 602; // changed
	int ConjunctionSuffix = 603;
	int FiniteVerbSuffix = 604;
	int NegativeFiniteVerbSuffix = 605;
	int PluralSuffix = 700;
	int SingularPluralSuffix = 701;
	int PastTenseMarker = 800;
	int PresentTenseMarker = 801;
	int FutureTenseMarker = 802;
	int VerbalParticipleSuffix = 900;
	int InfinitiveSuffix = 901;
	int NegativeConditionalSuffixSuffix = 902;
	int ConditionalSuffix = 903;
	int ImperativeSingularSuffix = 904;
	int ImperativePluralSuffix = 905;
	int PermissiveSuffix = 906;
	int ConcessiveSuffix = 907;
	int FutureNegativeSuffix = 908;
	int NegativeVerbalParticipleSuffix = 909;
	int ImperativeNegativeORProhibitive = 910;
	int RelativeParticipleSuffix = 911;
	int ParticleSuffix = 912;
	int PronomianlNeuterPlural = 1023;
	int PronominalThirdPersonMasculineSingular = 1311;
	int PronominalThirdPersonFemineSingular = 1312;
	int PronominalThirdPersonSingular = 1310;
	int PronominalThirdPersonPlural = 1320;
	int PronominalNeuterSingular = 1013;
	int Sandhi = 1401;
	int Oblique = 1402;
	int Euphonic = 1403;
	int ThirdFutureNeuterSingularORRP = 1501;
	int NeuterSingulerORPronominal = 1502; // changed
	int NeuterPluralSuffix = 2023;
	int NeuterSingularSuffix = 2013;
	int FirstPersonSingularSuffix = 2110;
	int FirstPersonPluralSuffix = 2120;
	int SecondPersonSingularSuffix = 2210;
	int SecondPersonPluralSuffix = 2220;
	int ThirdPersonMasculineSingularSuffix = 2311;
	int ThirdPersonFemimeSingularSuffix = 2312;
	int ThirdPersonSingularMasFemSuffix = 2310;
	int ThirdPersonPluralSuffix = 2320;
	int Clitic = 1;
	int Numbers =99;
	int cNumbers =98;
	int DT=97;
	int Enpavar=96;
	int Enpathu=95;
	int En     =94;
	int Entity = 50;
}

/* doubt - delete 18/05/2004
 int ThirdPersonSingularNeuter =     2313;//d
 int SecondPersonNeuterPlural =      2223;//d
 int SecondPersonNeuterSingular =    2213;//d
 */

/*
 add aux verb suffix
 */
