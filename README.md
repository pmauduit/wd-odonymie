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

Retrouver tous les objets taggués avec la clé OSM "highway=" qui ont une entrée
WD:

P31: "instance of"

https://wdq.wmflabs.org/api?q=claim[31:54114,88372,130954,445741,476352,510662,896009,907698,1006835,1133961,1251403,1308100,1571667,1787825,2144951,4471634,7543083,12163562,15070223,15212722]

172 objets, pas beaucoup ... :-)

utiliser une requete tree à la place ? Réponse: oui:


https://wdq.wmflabs.org/api?q=tree[54114,88372,130954,445741,476352,510662,896009,907698,1006835,1133961,1251403,1308100,1571667,1787825,2144951,4471634,7543083,12163562,15070223,15212722][][31]

1526 objets ...

Il faudrait trouver le moyen de faire marcher les sous-requêtes:
tree[(claim[279:79007])][][31]
marche pas.

Exemple de sous-requete qui fonctionne:
https://wdq.wmflabs.org/api?q=claim[31:(TREE[12280][][279])]%20AND%20tree[183][150][17,131]

Trouver les coordonnées géo des lavoirs de Wikidata
=====================================================

```
% curl  -gs 'https://wdq.wmflabs.org/api?q=claim[31:1690211]&props=625'
```

* `P31`: instance of
* `Q1690211`: lavoir
* `625`: coordonées géographiques

