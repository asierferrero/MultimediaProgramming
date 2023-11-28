using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class proba : MonoBehaviour
{
    // Start is called before the first frame update
    void Start()
    {
        Debug.Log("Hello World from Unity!");

        //move
        transform.position = Vector3.zero;//reset position to 0,0,0
        transform.position += Vector3.right * 3; //like new vector3(1*3,0,0) rotate
        transform.rotation = Quaternion.identity;//Reset rotation scale
        transform.localScale = Vector3.one;//Reset scale to 1,1,1
        //transform.localScale *= 2; //doble the scale
    }

    // Update is called once per frame
    void Update()
    {
        //moving
        transform.position -= new Vector3(0.001f, 0, 0);
        //rotating
        transform.rotation *= Quaternion.Euler(0, 0, 1);//+ isn't possible,we need to *
        //scalating
        transform.localScale += new Vector3(0.001f, 0, 0);
    }
}
