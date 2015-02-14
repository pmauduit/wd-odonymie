require 'wikidata'

#item = Wikidata::Item.find_by_title "boulevard de Magenta"
item = Wikidata::Item.find_by_id "Q895077"
item.resolve_claims!

puts item.claims.inspect
