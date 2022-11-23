kafka-topics --bootstrap-server localhost:9092 --describe --topic wikichangesresponses
kafka-topics --bootstrap-server localhost:9092 --delete --topic wikichangesresponses
kafka-topics --bootstrap-server localhost:9092 --list

--count messages in wikichangesresponses tipic:

kafka-run-class kafka.tools.GetOffsetShell --broker-list localhost:9092 --topic wikichangesresponses --time -1

kafka-topics --create --zookeeper zookeeper:2181 --topic wikichangesresponses --replication-factor 1 --partitions 1 --config "cleanup.policy=compact" --config min.cleanable.dirty.ratio=0.001 --config segment.ms=5000

http://localhost:8080/search?type=new&bot=false&page=0&user=TaxonBota&domain=commons.wikimedia.org

--mongodb CLI
mongo --port 27017 -u farid -p ff --authenticationDatabase fardb
use fardb
show collections
db.wikiChange.drop();
db.wikiChange.find();