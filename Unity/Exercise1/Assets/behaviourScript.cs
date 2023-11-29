using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class behaviourScript : MonoBehaviour
{
    private Vector3 position;
    int direction = 0;

    // Start is called before the first frame update
    void Start()
    {
        transform.position = position;
    }

    // Update is called once per frame
    void Update()
    {
        switch (direction)
        {
            case 0:
                transform.position += new Vector3(0.05f, 0, 0);
                break;
            case 1:
                transform.position -= new Vector3(0, 0, 0.05f);
                break;
            case 2:
                transform.position -= new Vector3(0.05f, 0, 0);
                break;
            case 3:
                transform.position += new Vector3(0, 0, 0.05f);
                break;
        }

        if (Mathf.Abs(transform.position.x - position.x) >= 1 || Mathf.Abs(transform.position.z - position.z) >= 1)
        {
            direction = (direction + 1) % 4;
        }
    }
}
