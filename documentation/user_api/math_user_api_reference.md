% MATH - User Api
% 
% 2020-10-28

---
papersize: a4
...

\newpage


# Specyfikacja funkcji

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

\textbf{Name} 		& \textbf{Description} 		& \textbf{Restrictions} 	\tabularnewline \bottomrule
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
      "image":"http://192.168.1.69:8125/images/topic/functions.png"
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




