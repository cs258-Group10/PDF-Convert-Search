#include<bits/stdc++.h>
#include<iostream>
#include <string>
#define ps push_back
using namespace std;
#define fre 	freopen("0.in","r",stdin);freopen("WITH_ABS.csv","w",stdout)

//vector<int> g[2*100000+5];int par[2*100000+5];
vector<string> sentence;
int AT;

string purify(string S)
{
	string T="";
	if(S[0]==' ')
	while(S.size()>0 and S[0]==' ')
	S.erase(S.begin());
	for(int i=0;i<S.size();++i)
	{
		if(S[i]!='\"')
			T+=S[i];
	}
	return T;
}


string  perform(string start_word, string end_word)
{
	start_word = purify(start_word);
	cout<<"\"";

	if(start_word.find(':')!=string::npos)
		cout<<start_word.substr(start_word.find(':')+1)<<' ';

	std::getline (std::cin,start_word);
	start_word=purify(start_word);

	while(start_word.substr(0,end_word.size())!=end_word)
	{
		if(start_word.find(':')!=string::npos)
			cout<<start_word.substr(start_word.find(':')+1)<<' ';
		else
			cout<<start_word<<' ';

		std::getline (std::cin,start_word);
		start_word=purify(start_word);
	}
	cout<<"\",";
	return start_word;
}
string  abstract(string start_word, string end_word,string e2)
{
	start_word = purify(start_word);
	cout<<"\"";

	if(start_word.find(':')!=string::npos)
		cout<<start_word.substr(start_word.find(':')+1)<<' ';

	std::getline (std::cin,start_word);
	start_word=purify(start_word);

	while(start_word.find(end_word)==string::npos and start_word.find(e2)==string::npos)
	{
		cout<<start_word<<' ';

		std::getline (std::cin,start_word);
		start_word=purify(start_word);
	}
	cout<<"\",";
	return start_word;
}
string to_string(int x)
{
	string S="";
	while(x>0)
	{
		S=(char)('0'+x%10)+S;
		x/=10;
	}
	return S;
}

vector<string> token(string S)
{
	vector<string>ans;
	ans.clear();

	for(int i=0;i<S.size();)
	{
		string temp="";

		while(S[i]!=' ' and i<S.size())
			temp+=S[i],++i;
		++i;
		if(temp!="")
			ans.ps(temp);

		while(S[i]==' ' and i<S.size())
			++i;
	}
	return ans;
}

bool is_a_date(string S)
{
	if(S.size()!=10)
		return 0;
	if(S[2]==S[5] and S[5]=='/')
	{
		return 1;
	}
	else return 0;

}

int get_next(string &S)
{
	if(AT>=sentence.size())
	{
		while(std::getline (std::cin,S))
		{
			sentence=token(S);
			if(sentence.size()==0)
				continue;
			if(S.find("Publication Under Section 43(2) in Respect of the Grant")!=string::npos)
			{
				return 2;
				AT=100000000;
			}
			AT=1;
			S=sentence[0];
			return 1;
		}
		return 0;
	}
	else
	{
		S=sentence[AT];
		AT++;
		return 1;
	}
}
void GRANTED_data_incoming()
{
	string HEAD="";
	HEAD+="Patent Number,Application No.,Date of Application,Date of Priority,Title of Invention AND Name of patentee,Date of Publication of Abstract,Appropriate Office\n";
	cout<<HEAD;
	string I,S;
	AT=100000000;
	int DEC,flag=0;
	for(int i=1;get_next(S);++i)
	{
		I=to_string(i);
		while(1)
		{
			if(S==I)
				break;
			else

			DEC=get_next(S);

			if(DEC==0)
				return;
			else
			if(flag==0 and DEC==2)
			{
				flag=1;
				i=1;
				I=to_string(i);
			}
		}


		get_next(S);					//PatentNumber
		cout<<"\""<<S<<"\",";

		get_next(S);					//Application Number
		cout<<"\""<<S<<"\",";

		get_next(S);					//Date of Application

		if(!is_a_date(S))
		{
			S="";
			AT--;
		}
		cout<<"\""<<S<<"\",";

		get_next(S);					//Date of Priority
		if(!is_a_date(S))
		{
			S="";
			AT--;
		}
		cout<<"\""<<S<<"\",";

		S=purify(S);
		cout<<"\"";
			//cout<<"\nTitle of Invention 		and			 	Name of Patentee\n";
		while(get_next(S))
		{
			S=purify(S);
			if(is_a_date(S))
				break;
			cout<<S<<' ';
		}
		cout<<"\",";

		cout<<"\""<<S<<"\","; 		//Date of Publication of Abstract u/s 11(A)

		get_next(S);					//Appropriation Office
		cout<<"\""<<S<<"\",";
		cout<<endl;
	}
}
int main(int argc, char *argv[])
{
	char *I1=" Early Publication.csv";
	char *I2=" Publication After 18 Months.csv";
	char *I3=" GRANTED.csv";


	freopen(argv[1],"r",stdin);

	char *OUTPUT_1=new char[strlen(argv[1])+strlen(I1)+1];
	strcpy(OUTPUT_1,argv[1]);
	strcat(OUTPUT_1,I1);

	freopen(OUTPUT_1,"w",stdout);


	string start="(12) PATENT APPLICATION PUBLICATION";
	//string end_string="(57) Abstract : ";
	string L3="(22) Date of filing of Application :";
	string S;
	int T=0;
	string c1="\"APPLICATION NUMBER\",\"DATE OF FILLING APPLICATION\",\"PUBLICATION DATE\",\"TITLE OF INVENTION\",\"International classification\",";
	c1+="\"Priority Document No\",\"PRIORITY DATE\",\"NAME OF PRIORITY COUNTRY\",\"INTERNATIONAL APPLICATION NUMBER\",\"INTERNATIONAL APPLICATION NO. FILLING DATE\",";
	c1+="\"INTERNATIONAL PUBLICATION NUMBER\",\"Patent of Addition to Application Number\",\"Patent of Addition to Application Number FILLING DATE\",\"DIVISIONAL TO APPLICATION NUMBER\",\"DIVISIONAL TO APPLICATION NUMBER FILLING DATE\"";
	c1+=",\"DETAIL OF APPLICANT\",\"DETAIL OF INVENTOR\",\"ABSTRACT\"";
	cout<<c1<<endl;
	int Pub_after_18_open=0;
	while(std::getline (std::cin,S))
	{
		S=purify(S);

		if(S.find("Publication Under Section 43(2) in Respect of the Grant")!=string::npos)
		{
			fclose (stdout);

			char *OUTPUT_3=new char[strlen(argv[1])+strlen(I3)+1];
			strcpy(OUTPUT_3,argv[1]);
			strcat(OUTPUT_3,I3);
			freopen(OUTPUT_3,"w",stdout);

			GRANTED_data_incoming();

			fclose (stdout);

			if(remove(argv[1])!=0)
			perror("ERROR aa gaya x");

			return 0;
		}
		if(S.find("Publication After 18 Months :")!=string::npos and Pub_after_18_open==0 or S.find("Publication After 18 Months:")!=string::npos)
		{
			Pub_after_18_open=1;
			fclose (stdout);

			char *OUTPUT_2=new char[strlen(argv[1])+strlen(I2)+1];
			strcpy(OUTPUT_2,argv[1]);
			strcat(OUTPUT_2,I2);
			freopen(OUTPUT_2,"w",stdout);

		}
		if(S.size()>=start.size() and S.substr(0,start.size())==start)
		{
			//dealing with first three lines

			/*
			(12) PATENT APPLICATION PUBLICATION (21) Application No.329/CHE/2009 A
			(19) INDIA
			(22) Date of filing of Application :14/02/2009 (43) Publication Date : 03/04/2009
			(54) Title of the invention : Using rack and pinions to drive the power output shaft in an internal combustion engine
			*/

			cout<<"\""<<S.substr(S.find('.')+1)<<"\",";	//printing data after '.' (i.e. application number)
			std::getline (std::cin,S);//skip (19)india
			std::getline (std::cin,S);//now S contains the third Line
			S=purify(S);

			cout<<"\""<<S.substr(S.find(':')+1,10)<<"\",";//assunming date of filing application contains 10 characters + just after ':'

			cout<<"\""<<S.substr(S.find(": ")+2)<<"\",";//assunming Publication Date to be contained just after ": " + there is space after ':'

			std::getline (std::cin,S);//skip (19)india
			S=purify(S);

			//--------------TITLE OF INVENTION-------------------------
			S=perform(S,"(51) International");

			//--------------INTERNATIONAL CLASSIFICATION-------------------------
			S=perform(S,"(31) Priority Document");

			//--------------PRIORITY DOCUMENT NUMBER-------------------------
			S=perform(S,"(32) Priority Date");

			//--------------PRIORITY DATE-------------------------
			S=perform(S,"(33) Name of priority country");

			//--------------PRIORITY COUNTRY-------------------------
			S=perform(S,"(86) International Application");

			//--------------INTERNATIONAL APP NO. AND FILLING DATE-------------------------
			std::getline (std::cin,S);
			std::getline (std::cin,S);
			S=purify(S);

			cout<<"\"";
			cout<<S.substr(S.find(':')+1)<<' ';
			std::getline (std::cin,S);
			S=purify(S);
			while(S.substr(0,string(":").size())!=":")
			{
				cout<<S<<' ';
				std::getline (std::cin,S);
				S=purify(S);

			}
			cout<<"\",";

			cout<<"\"";
			cout<<S.substr(S.find(':')+1)<<' ';
			std::getline (std::cin,S);
			S=purify(S);
			while(S.substr(0,string("(87) International Publication").size())!="(87) International Publication")
			{
				cout<<S<<' ';
				std::getline (std::cin,S);
				S=purify(S);
			}
			cout<<"\",";

			//--------------INTERNATIONAL PUBLICATION-------------------------
			S=perform(S,"(61) Patent of Addition to");

			//--------------Patent of Addition to Application Number and Filing Date-------------------------
			while(S.find(":")==string::npos)
				std::getline (std::cin,S);
			S=purify(S);
			cout<<"\"";
			cout<<S.substr(S.find(':')+1)<<' ';
			std::getline (std::cin,S);
			S=purify(S);
			while(S.substr(0,string(":").size())!=":")
			{
				cout<<S<<' ';
				std::getline (std::cin,S);
				S=purify(S);
			}
			cout<<"\",";

			cout<<"\"";
			cout<<S.substr(S.find(':')+1)<<' ';
			std::getline (std::cin,S);
			S=purify(S);
			while(S.substr(0,string("(62) Divisional to Application Number").size())!="(62) Divisional to Application Number")
			{
				cout<<S<<' ';
				std::getline (std::cin,S);
				S=purify(S);
			}
			cout<<"\",";

			//--------------divisional application number AND FILLING DATE-------------------------
			std::getline (std::cin,S);
			std::getline (std::cin,S);
			S=purify(S);
			cout<<"\"";
			cout<<S.substr(S.find(':')+1)<<' ';
			std::getline (std::cin,S);
			S=purify(S);
			while(S.substr(0,string(":").size())!=":")
			{
				cout<<S<<' ';
				std::getline (std::cin,S);
				S=purify(S);
			}
			cout<<"\",";

			cout<<"\"";
			cout<<S.substr(S.find(':')+1)<<' ';
			std::getline (std::cin,S);
			S=purify(S);
			while(S.substr(0,string("(71)Name of Applicant").size())!="(71)Name of Applicant")
			{
				cout<<S<<' ';
				std::getline (std::cin,S);
				S=purify(S);
			}
			cout<<"\",";

			//--------------DETAIL OF APPLICANT-------------------------
			S=perform(S,"(72)Name of Inventor :");

			//--------------DETAIL OF INVENTOR-------------------------
			S=perform(S,"(57) Abstract :");

			//--------------abstract-------------------------
			S=abstract(S,"The Patent Office Journal","No. of Pages");
			cout<<endl;
			//return 0;
		}
	}
	fclose (stdout);
	freopen("Window","w",stdout);
	if(remove(argv[1])!=0)
		perror("ERROR ");
	return 0;
}
