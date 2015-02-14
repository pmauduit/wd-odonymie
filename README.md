odonymie
===========

Projet cherchant à pouvoir faire le lien entre 2 bases de données:

- OpenStreetMap pour les données géographiques
- Wikidata pour le lien vers la nébuleuse des projets wikimedia

Notes en vrac
==============

- "Boulevard de Magenta" (à Paris) -> Q895077

- Q895077 est une sous-classe (P279) de Boulevard (Q54114)

- Q54114 ("Boulevard") est une sous-classe (P:279) de Street (Q79007)

Trouver toutes les sous-classes de rues: utiliser une requête "claim"

https://wdq.wmflabs.org/api?q=claim[279:79007]

Cela permet de sortir toute la hiérarchie des objets, et en plus il y a un lien
OpenStreetMap via la propriété P1282 ("OpenStreetMap tag or key")

Pour aller plus loin, on pourrait à partir d'un tag osm donné, retrouver toute
la hiérarchie des objets WD:

https://wdq.wmflabs.org/api?q=string[1282:%22Key:highway%22]


