% MATH - User Api
% 
% 2020-10-28

---
papersize: a4
...

\newpage


# Specyfikacja funkcji

## Funkcje dotyczące operacji użytkownika

### Rejestracja

\textbf{Podsumowanie}

\begin{small}
\begin{longtable}{@{}p{3cm}p{10cm}@{}}
\toprule
\endhead

\textbf{Metoda}					& POST										\tabularnewline \hline
\textbf{Endpoint}				& /register									\tabularnewline \hline
\textbf{Opis}					& Pozwala na utworzenie nowego użytkownika			\tabularnewline \hline
\textbf{Dostęp}					& Bez autoryzacji							\tabularnewline \hline
\textbf{Zwracane kody}	& -											\tabularnewline
\bottomrule
\end{longtable}
\end{small}
				
\textbf{Parametry wejściowe}

\begin{small}
\begin{longtable}{@{}p{3cm}p{6cm}p{37mm}@{}}
\toprule
\endhead

\textbf{Nazwa} 		& \textbf{Opis} 		& \textbf{Restrykcje} 	\tabularnewline \bottomrule
email				& adres email 		    &			-				\tabularnewline \hline
password			& hasło użytkownika 	&			-				\tabularnewline

\bottomrule
\end{longtable}
\end{small}

\textbf{Przykładowe żądanie}

\begin{lstlisting}[backgroundcolor=\color{gray},frame=single,basicstyle=\ttfamily]
POST@/register
{
  "email": "test@gmail.com",
  "password": "123123123" 
}
\end{lstlisting}


### logowanie

\textbf{Podsumowanie}

\begin{small}
\begin{longtable}{@{}p{3cm}p{10cm}@{}}
\toprule
\endhead

\textbf{Metoda}					& POST										\tabularnewline \hline
\textbf{Endpoint}				& /login								\tabularnewline \hline
\textbf{Opis}					& Logowanie użytkownika, zwracany zostaje token jwt w nagłówku odpowiedzi HTTP			\tabularnewline \hline
\textbf{Dostęp}					& Bez autoryzacji							\tabularnewline \hline
\textbf{Zwracane kody}	& -											\tabularnewline
\bottomrule
\end{longtable}
\end{small}
				
\textbf{Parametry wejściowe}

\begin{small}
\begin{longtable}{@{}p{3cm}p{6cm}p{37mm}@{}}
\toprule
\endhead

\textbf{Nazwa} 		& \textbf{Opis} 		& \textbf{Restrykcje} 	\tabularnewline \bottomrule
login				& adres email 		    &			-				\tabularnewline \hline
password			& hasło użytkownika 	&			-				\tabularnewline

\bottomrule
\end{longtable}
\end{small}

\textbf{Przykładowe żądanie}

\begin{lstlisting}[backgroundcolor=\color{gray},frame=single,basicstyle=\ttfamily]
POST@/register
{
  "login": "test@gmail.com",
  "password": "123123123" 
}
\end{lstlisting}



## Funkcje dotyczące zagadnień matematyki

### Pobieranie listy zagadnień

\textbf{Podsumowanie}

\begin{small}
\begin{longtable}{@{}p{3cm}p{10cm}@{}}
\toprule
\endhead

\textbf{Metoda}					& GET										\tabularnewline \hline
\textbf{Endpoint}				& /topics									\tabularnewline \hline
\textbf{Opis}					& Zwraca listę zagadnień matematyki			\tabularnewline \hline
\textbf{Dostęp}					& Wymagana autoryzacja							\tabularnewline \hline
\textbf{Zwracane kody}	& -											\tabularnewline
\bottomrule
\end{longtable}
\end{small}
				
\textbf{Parametry wejściowe}

\begin{small}
\begin{longtable}{@{}p{3cm}p{6cm}p{37mm}@{}}
\toprule
\endhead

\textbf{Nazwa} 		& \textbf{Opis} 		& \textbf{Restrykcje} 	\tabularnewline \bottomrule
				&  		&							\tabularnewline \hline
			& 			&							\tabularnewline

\bottomrule
\end{longtable}
\end{small}

\textbf{Przykładowe żądanie}

\begin{lstlisting}[backgroundcolor=\color{gray},frame=single,basicstyle=\ttfamily]
GET@/topics
\end{lstlisting}

\textbf{Przykładowa odpowiedź}
\begin{lstlisting}[backgroundcolor=\color{gray},frame=single,basicstyle=\ttfamily]
{
  "content":[
    {
      "name":"funkcje",
      "desc":"Jakis opis",
      "image":"http://192.168.1.69:8125/images/course/functions.png"
    }
  ],
  "pageable":{
    "sort":{
      "sorted":true,
      "unsorted":false,
      "empty":false
    },
    "offset":0,
    "pageNumber":0,
    "pageSize":20,
    "paged":true,
    "unpaged":false
  },
  "totalPages":1,
  "totalElements":1,
  "last":true,
  "first":true,
  "sort":{
    "sorted":true,
    "unsorted":false,
    "empty":false
  },
  "size":20,
  "number":0,
  "numberOfElements":1,
  "empty":false
}
\end{lstlisting}

## Funkcje dotyczące ćwiczeń

### Pobieranie listy ćwiczeń

\textbf{Podsumowanie}

\begin{small}
\begin{longtable}{@{}p{3cm}p{10cm}@{}}
\toprule
\endhead

\textbf{Metoda}					& GET										\tabularnewline \hline
\textbf{Endpoint}				& /exercises									\tabularnewline \hline
\textbf{Opis}					& Zwraca listę zadań			\tabularnewline \hline
\textbf{Dostęp}					& Wymgaana autoryzacja							\tabularnewline \hline
\textbf{Zwracane kody}	& -											\tabularnewline
\bottomrule
\end{longtable}
\end{small}
				
\textbf{Parametry wejściowe}

\begin{small}
\begin{longtable}{@{}p{3cm}p{6cm}p{37mm}@{}}
\toprule
\endhead

\textbf{Nazwa} 		& \textbf{Opis} 		& \textbf{Restrykcje} 	\tabularnewline \bottomrule
course				&  Nazwa tematyki, której mają dotyczyć ćwiczenia		&			-				\tabularnewline
isSolved            & Pokazuj tylko rozwiązane/nierozwiązane ćwiczenia przez zalogowanego użytkownikas & tylko false działa	

\bottomrule
\end{longtable}
\end{small}

\textbf{Przykładowe żądanie}

\begin{lstlisting}[backgroundcolor=\color{gray},frame=single,basicstyle=\ttfamily]
GET@/exercises?course=trygonometria
\end{lstlisting}

### Udzielenie odpowiedzi

\textbf{Podsumowanie}

\begin{small}
\begin{longtable}{@{}p{3cm}p{10cm}@{}}
\toprule
\endhead

\textbf{Metoda}					& POST										\tabularnewline \hline
\textbf{Endpoint}				& /exercises/{id}/answer									\tabularnewline \hline
\textbf{Opis}					& Udzielenie odpowiedzi (popranwa/niepoprawna) na zadanie o danym id			\tabularnewline \hline
\textbf{Dostęp}					& Wymagana autoryzacja						\tabularnewline \hline
\textbf{Zwracane kody}	& -											\tabularnewline
\bottomrule
\end{longtable}
\end{small}
				
\textbf{Parametry wejściowe}

\begin{small}
\begin{longtable}{@{}p{3cm}p{6cm}p{37mm}@{}}
\toprule
\endhead

\textbf{Nazwa} 		& \textbf{Opis} 		& \textbf{Restrykcje} 	\tabularnewline \bottomrule
isCorrect				&  Czy udzielona odpowiedż jest poprawna		&	Boolean		-				\tabularnewline
\bottomrule
\end{longtable}
\end{small}

\textbf{Przykładowe żądanie}

\begin{lstlisting}[backgroundcolor=\color{gray},frame=single,basicstyle=\ttfamily]
POST@/exercises/1/answer
{
  "isCorrect":true
}
\end{lstlisting}
