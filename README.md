## PDV - publish ( send a sale to nats)

- Json structure example
{
    "productId":"fd30c105-cd09-47b6-8422-229a542a0c25",
	"qty":21.0
}

---

## CADVENDA  - Subscriber ( receiver from PDV and save sales in Scylla database)

- Strucure to receive

-- Message + newSale( productId, qty )
-- when received a message to SAVE, verify if exist product into the base and persist the sale


