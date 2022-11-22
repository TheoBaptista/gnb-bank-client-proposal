from fastapi import FastAPI, HTTPException

app = FastAPI()


class Card:
    def __init__(self,cpf) -> None:
        super().__init__()
        self.cpf = cpf
        self.number = "1111 2222 3333 4444"
        self.valid = "08/30"
        self.cvu = "156"


def sanitize_cpf(cpf):
    if type(cpf) == str:
        return cpf.strip()
    else:
        return "dar erro"


@app.get("/check/{cpf}")
async def read_root(cpf: str):
    clean_cpf = sanitize_cpf(cpf)

    negative_cpf = ["044", "055"]
    slice_cpf = clean_cpf[0:3]

    if slice_cpf in negative_cpf:
        raise HTTPException(status_code=422, detail="client recused")

    return Card(clean_cpf)
