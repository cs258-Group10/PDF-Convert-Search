#include<bits/stdc++.h>
#include<iostream>
using namespace std;
#define fre 	freopen("0.in","r",stdin);freopen("WITH_ABS.csv","w",stdout)
#define abs(x) ((x)>0?(x):-(x))
#define M 1000000007
#define lld signed long long int
#define pp pop_back()
#define ps(x) push_back(x)
#define mpa make_pair
#define pii pair<int,int>
#define fi first
#define se second
#define scan(x) scanf("%d",&x)
#define print(x) printf("%d\n",x)
#define scanll(x) scanf("%lld",&x)
#define printll(x) printf("%lld\n",x)
#define boost ios_base::sync_with_stdio(0)
//vector<int> g[2*100000+5];int par[2*100000+5];

vector<string> token(string S)
{
	vector<string>ans;
	ans.clear();

	for(int i=0;i<S.size();)
	{
		string temp="";

		while(S[i]!=' ')
			temp+=S[i],++i;
		++i;
		ans.ps(temp);

	}
	return ans;
}

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

int main()
{
	freopen("0.in","r",stdin);
	freopen("WITH_ABS.csv","w",stdout);

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
	while(std::getline (std::cin,S))
	{
		S=purify(S);
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
	return 0;
}
